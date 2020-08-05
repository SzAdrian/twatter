using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Controllers.Responses;
using Twatter_Backend_csharp.Units.Interface;

namespace Twatter_Backend_csharp.Controllers
{
    [Route("trending-tweets")]
    [ApiController]
    public class TrendingTweetsController : Controller
    {
        private readonly IUnitOfWork _repository;

        public TrendingTweetsController(IUnitOfWork repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> GetTrendingTweets([FromQuery] string hashtag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ControllerResponse.InvalidModelState.ToString());
            }

            if (hashtag == null)
            {
                return BadRequest(ControllerResponse.HashtagCannotBeNull.ToString());
            }

            var tweetIds = await _repository.HashtagRepository.GetTweetIds(hashtag);

            return Ok(tweetIds);
        }

    }
}
