using Microsoft.AspNetCore.Mvc;
using System;
using System.Globalization;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Controllers.Responses;
using Twatter_Backend_csharp.Models;
using Twatter_Backend_csharp.Units.Interface;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Twatter_Backend_csharp.Controllers
{
    [Route("trending")]
    [ApiController]
    public class TrendingHashtagsController : Controller
    {
        private readonly IUnitOfWork _repository;

        public TrendingHashtagsController(IUnitOfWork repository)
        {
            _repository = repository;
        }

        // Needs documentation !

        [HttpPost]
        public async Task<IActionResult> AddHashtagsFromTweet([FromBody] Tweet tweet)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            if (tweet == null)
            {
                return BadRequest(ControllerResponse.HashtagCannotBeNull.ToString());
            }

            
            var hashtags =  _repository.HashtagRepository.GetHashtagsFromTweet(tweet);

            var result = await _repository.HashtagRepository.AddRange(hashtags);

            if (!result) return StatusCode(500, ControllerResponse.AddingHashtagFailed.ToString());

            await _repository.Complete();

            return Ok(ControllerResponse.AddingHashtagSuccesfull.ToString());
        }

        [HttpPost("AddHashtag")]
        public async Task<IActionResult> AddHashtag([FromBody] Hashtag hashtag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            if(hashtag == null)
            {
                return BadRequest(ControllerResponse.HashtagCannotBeNull.ToString());
            }

            hashtag.Date = DateTime.Now;
            var result = await _repository.HashtagRepository.Add(hashtag);

            if (!result) return StatusCode(500, ControllerResponse.AddingHashtagFailed.ToString());

            await _repository.Complete();

            return Ok(ControllerResponse.AddingHashtagSuccesfull.ToString()); 
        }

        // Needs documentation !

        //TrendingHashtags:
        //  -This method returns the top 20 trending hashtags filtered by a specified date.
        //
        //Params: 
        //  - string Date : The specified Date in string fromat for filtering hashtags.
        //

        [HttpGet]
        public async Task<IActionResult> TrendingHashtags([FromQuery]string date)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            if(date == null)
            {
                return BadRequest(ControllerResponse.InvalidDateFormat.ToString());
            }

            DateTime TimeFilter;
            try
            {
                TimeFilter = Convert.ToDateTime(date, CultureInfo.InvariantCulture);
            }
            catch(FormatException ex)
            {
                Console.WriteLine(ex.Message);
                return BadRequest(ControllerResponse.InvalidDateFormat.ToString());
            }
            
            var FilteredHashtags = await _repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(TimeFilter);

            if(FilteredHashtags == null)
            {
                return NotFound(ControllerResponse.FilteredHashtagsNotFound.ToString());
            }

            return Ok(FilteredHashtags);
        }

        // Needs documentation !

        [HttpGet("daily")]
        public async Task<IActionResult> DailyTrendingHashtags()
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            var TodaysDate = DateTime.Today.Date;
            var DailyTrendingHashtags = await _repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(TodaysDate);

            if (DailyTrendingHashtags == null)
            {
                return NotFound(ControllerResponse.DailyHashtagsNotFound.ToString());
            }

            return Ok(DailyTrendingHashtags);
        }

        // Needs documentation !

        [HttpGet("weekly")]
        public async Task<IActionResult> WeeklyTrendingHashtags()
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            var DateAWeekAgo = DateTime.Today.Subtract(TimeSpan.FromDays(7));
            var WeeklyTrendingHashtags = await _repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(DateAWeekAgo);

            if (WeeklyTrendingHashtags == null)
            {
                return NotFound(ControllerResponse.WeeklyHashtagsNotFound.ToString());
            }

            return Ok(WeeklyTrendingHashtags);
        }

        // Needs documentation !

        [HttpGet("monthly")]
        public async Task<IActionResult> MonthlyTrendingHashtags()
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            var CurrentMonth = new DateTime(DateTime.Now.Year, DateTime.Now.Month, 1);
            var MonthlyTrendingHashtags = await _repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(CurrentMonth);

            if (MonthlyTrendingHashtags == null)
            {
                return NotFound(ControllerResponse.MonthlyHashtagsNotFound.ToString());
            }

            return Ok(MonthlyTrendingHashtags);
        }

    }
}
