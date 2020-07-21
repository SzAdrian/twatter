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
    [Route("TrendingHashtags")]
    [ApiController]
    public class TrendingHashtagsController : Controller
    {

        private readonly IUnitOfWork _repository;

        public TrendingHashtagsController(IUnitOfWork repository)
        {
            _repository = repository;
        }

        [HttpPost("AddHashtag")]
        public async Task<IActionResult> AddHashtag([FromBody] Hashtag hashtag)
        {
            //TODO !

            return Ok();
        }

        //
        // Needs unit tests !
        //

        [HttpGet]
        public async Task<IActionResult> TrendingHashtags([FromQuery]string date)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            var Provider = CultureInfo.InvariantCulture;
            var Format = "MM/dd/yyyy HH:mm:ss.ffffff";
            DateTime TimeFilter;

            try
            {
                TimeFilter = DateTime.ParseExact(date,Format,Provider);
            }
            catch(FormatException ex)
            {
                Console.WriteLine(ex.Message);
                return BadRequest(ControllerResponse.InvalidTimeFilter.ToString());
            }
            
            var FilteredHashtags = await _repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(TimeFilter);

            if(FilteredHashtags == null)
            {
                return NotFound(ControllerResponse.FilteredHashtagsNotFound.ToString());
            }

            return Ok(FilteredHashtags);
        }

        [HttpGet("Daily")]
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

        [HttpGet("Weekly")]
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

        [HttpGet("Monthly")]
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
