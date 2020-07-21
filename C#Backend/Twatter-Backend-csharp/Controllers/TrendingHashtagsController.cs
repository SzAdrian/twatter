using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Twatter_Backend_csharp.Controllers.Responses;
using Twatter_Backend_csharp.Units.Interface;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Twatter_Backend_csharp.Controllers
{
    [Route("Trending")]
    [ApiController]
    public class TrendingHashtagsController : Controller
    {

        private readonly IUnitOfWork _repository;

        public TrendingHashtagsController(IUnitOfWork repository)
        {
            _repository = repository;
        }

        [HttpGet("Daily")]
        public async Task<IActionResult> DailyTrendingHashtags()
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            var DailyTrendingHashtags = await _repository.HashtagRepository.GetDailyTrendingHashtags();

            if (DailyTrendingHashtags == null)
            {
                return NotFound(ControllerResponse.DailyHashtagsNotFound.ToString());
            }

            return Ok(DailyTrendingHashtags);

        }
    }
}
