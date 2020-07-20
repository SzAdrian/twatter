using System;
using Xunit;
using NSubstitute;
using Twatter_Backend_csharp.Controllers;
using Twatter_Backend_csharp.Units.Interface;
using NSubstitute.ReturnsExtensions;
using Microsoft.AspNetCore.Mvc;
using Twatter_Backend_csharp.Controllers.Responses;
using System.Collections.Generic;

namespace Twatter_TrendingHashtagsController_Tests
{
    public abstract class TestsBase : IDisposable
    {
        protected TrendingHashtagsController controller;
        protected IUnitOfWork repository;

        protected TestsBase()
        {
            // Do "global" initialization here; Called before every test method.
            this.repository = Substitute.For<IUnitOfWork>();
            this.controller = new TrendingHashtagsController(repository);
        }

        public void Dispose()
        {
            // Do "global" teardown here; Called after every test method.
        }
    }
    public class TrendingHashtagsControllerTests : TestsBase
    {
        [Fact]
        public async void DailyTrendingHashtags_Returns_NotFoundObjectResult_With_DailyHashtagsNotFound_When_RepositoryReturnsNull()
        {
            repository.HashtagRepository.GetDailyTrendingHashtags().ReturnsNull();

            var result = await controller.DailyTrendingHashtags();
            var NotFoundObjectResult = Assert.IsType<NotFoundObjectResult>(result);
            var DailyHashtagsNotFoundString = Assert.IsType<string>(NotFoundObjectResult.Value);

            Assert.Equal(ControllerResponse.DailyHashtagsNotFound.ToString(), DailyHashtagsNotFoundString);
        }

        [Fact]
        public async void DailyTrendingHashtags_Returns_OkObjectResult_With_ListOfHashtags()
        {
            var dbData = new List<object>();

            dbData.Add(new { hashtag = "covid", count = 3 });
            dbData.Add(new { hashtag = "sad", count = 1 });
            dbData.Add(new { hashtag = "workout", count = 1 });

            repository.HashtagRepository.GetDailyTrendingHashtags().Returns(dbData);

            var result = await controller.DailyTrendingHashtags();
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var ListOfObjects = Assert.IsType<List<object>>(OkObjectResult.Value);

            Assert.Equal(new { hashtag = "covid", count = 3 }, ListOfObjects[0]);
        }

        [Fact]
        public async void WeeklyTrendingHashtags_Returns_NotFoundObjectResult_With_WeeklyyHashtagsNotFound_When_RepositoryReturnsNull()
        {
            repository.HashtagRepository.GetWeeklyTrendingHashtags().ReturnsNull();

            var result = await controller.WeeklyTrendingHashtags();
            var NotFoundObjectResult = Assert.IsType<NotFoundObjectResult>(result);
            var WeeklyHashtagsNotFoundString = Assert.IsType<string>(NotFoundObjectResult.Value);

            Assert.Equal(ControllerResponse.WeeklyHashtagsNotFound.ToString(), WeeklyHashtagsNotFoundString);
        }

        [Fact]
        public async void WeeklyTrendingHashtags_Returns_OkObjectResult_With_ListOfHashtags()
        {
            var dbData = new List<object>();

            dbData.Add(new { hashtag = "covid", count = 13 });
            dbData.Add(new { hashtag = "summer", count = 8 });
            dbData.Add(new { hashtag = "quarantine", count = 4 });

            repository.HashtagRepository.GetWeeklyTrendingHashtags().Returns(dbData);

            var result = await controller.WeeklyTrendingHashtags();
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var ListOfObjects = Assert.IsType<List<object>>(OkObjectResult.Value);

            Assert.Equal(new { hashtag = "covid", count = 13 }, ListOfObjects[0]);
        }

    }
}
