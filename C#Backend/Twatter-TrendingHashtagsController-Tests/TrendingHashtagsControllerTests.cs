using System;
using Xunit;
using NSubstitute;
using Twatter_Backend_csharp.Controllers;
using Twatter_Backend_csharp.Units.Interface;
using NSubstitute.ReturnsExtensions;
using Microsoft.AspNetCore.Mvc;
using Twatter_Backend_csharp.Controllers.Responses;
using System.Collections.Generic;
using Twatter_Backend_csharp.Models;

namespace Twatter_TrendingHashtagsController_Tests
{
    public abstract class TestsBase : IDisposable
    {
        protected TrendingHashtagsController controller;
        protected IUnitOfWork repository;

        protected TestsBase()
        {
            // Do "global" initialization here; Called before every test method.
            repository = Substitute.For<IUnitOfWork>();
            controller = new TrendingHashtagsController(repository);
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
            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).ReturnsNull();

            var result = await controller.DailyTrendingHashtags();
            var NotFoundObjectResult = Assert.IsType<NotFoundObjectResult>(result);
            var DailyHashtagsNotFoundString = Assert.IsType<string>(NotFoundObjectResult.Value);

            Assert.Equal(ControllerResponse.DailyHashtagsNotFound.ToString(), DailyHashtagsNotFoundString);
        }

        [Fact]
        public async void DailyTrendingHashtags_Returns_OkObjectResult_With_ListOfHashtags()
        {
            object[] dbData = { new { hashtag = "covid", count = 13 },
                new { hashtag = "summer", count = 8 },
                new { hashtag = "quarantine", count = 4 }
            };
            var TodaysDate = DateTime.Today.Date;

            var list = new HashtagList { TimeFilter = TodaysDate, TrendingHashtags = dbData };

            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).Returns(list);

            var result = await controller.DailyTrendingHashtags();
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var HashtagList = Assert.IsType<HashtagList>(OkObjectResult.Value);

            Assert.Equal(new { hashtag = "covid", count = 13 }, HashtagList.TrendingHashtags[0]);
            Assert.Equal(TodaysDate, HashtagList.TimeFilter);
        }

        [Fact]
        public async void WeeklyTrendingHashtags_Returns_NotFoundObjectResult_With_WeeklyyHashtagsNotFound_When_RepositoryReturnsNull()
        {
            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).ReturnsNull();

            var result = await controller.WeeklyTrendingHashtags();
            var NotFoundObjectResult = Assert.IsType<NotFoundObjectResult>(result);
            var WeeklyHashtagsNotFoundString = Assert.IsType<string>(NotFoundObjectResult.Value);

            Assert.Equal(ControllerResponse.WeeklyHashtagsNotFound.ToString(), WeeklyHashtagsNotFoundString);
        }

        [Fact]
        public async void WeeklyTrendingHashtags_Returns_OkObjectResult_With_ListOfHashtags()
        {
            object[] dbData = { new { hashtag = "covid", count = 13 },
                new { hashtag = "summer", count = 8 },
                new { hashtag = "quarantine", count = 4 }
            };

            var DateAWeekAgo = DateTime.Today.Subtract(TimeSpan.FromDays(7));

            var list = new HashtagList { TimeFilter = DateAWeekAgo, TrendingHashtags = dbData };

            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).Returns(list);

            var result = await controller.WeeklyTrendingHashtags();
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var HashtagList = Assert.IsType<HashtagList>(OkObjectResult.Value);

            Assert.Equal(new { hashtag = "covid", count = 13 }, HashtagList.TrendingHashtags[0]);
            Assert.Equal(DateAWeekAgo, HashtagList.TimeFilter);
        }

        [Fact]
        public async void MothlyTrendingHashtags_Returns_NotFoundObjectResult_With_MothlyHashtagsNotFound_When_RepositoryReturnsNull()
        {
            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).ReturnsNull();

            var result = await controller.MonthlyTrendingHashtags();
            var NotFoundObjectResult = Assert.IsType<NotFoundObjectResult>(result);
            var MonthlyHashtagsNotFoundString = Assert.IsType<string>(NotFoundObjectResult.Value);

            Assert.Equal(ControllerResponse.MonthlyHashtagsNotFound.ToString(), MonthlyHashtagsNotFoundString);
        }

        [Fact]
        public async void MonthlyTrendingHashtags_Returns_OkObjectResult_With_ListOfHashtags()
        {
            object[] dbData = { new { hashtag = "covid", count = 13 },
                new { hashtag = "summer", count = 8 },
                new { hashtag = "quarantine", count = 4 }
            };
            var TimeInterval = new DateTime(DateTime.Now.Year, DateTime.Now.Month, 1);

            var list = new HashtagList { TimeFilter = TimeInterval, TrendingHashtags = dbData };

            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).Returns(list);

            var result = await controller.MonthlyTrendingHashtags();
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var HashtagList = Assert.IsType<HashtagList>(OkObjectResult.Value);

            Assert.Equal(new { hashtag = "covid", count = 13 }, HashtagList.TrendingHashtags[0]);
            Assert.Equal(TimeInterval, HashtagList.TimeFilter);
        }

        [Fact]
        public async void TrendingHashtags_CalledWithNull_Returns_BadRequestObjectResult_With_InvalidDateFormat()
        {
            var ExpetedInvalidDateFormatString = ControllerResponse.InvalidDateFormat.ToString();

            var result = await controller.TrendingHashtags(null);
            var BadRequesrObjectResult = Assert.IsType<BadRequestObjectResult>(result);
            var InvalidDateFormatString = Assert.IsType<string>(BadRequesrObjectResult.Value);

            Assert.Equal(ExpetedInvalidDateFormatString, InvalidDateFormatString);
        }

        [Fact]
        public async void TrendingHashtags_CalledWithInvalidDate_Returns_BadRequestObjectResult_With_InvalidDateFormat()
        {
            var ExpetedInvalidDateFormatString = ControllerResponse.InvalidDateFormat.ToString();
            var InvalidDate = "07/21/2020 16:00:00 AM";

            var result = await controller.TrendingHashtags(InvalidDate);
            var BadRequesrObjectResult = Assert.IsType<BadRequestObjectResult>(result);
            var InvalidDateFormatString = Assert.IsType<string>(BadRequesrObjectResult.Value);

            Assert.Equal(ExpetedInvalidDateFormatString, InvalidDateFormatString);
        }
        [Fact]
        public async void TrendingHastags_CalledWithValidDate_Returns_NotFoundObjectResult_With_FilteredHashtagsNotFound_When_RepositoryReturnNull()
        {
            var ValidDate = "07/21/2020 12:00:00 AM";
            var ValidDateDateTimeFormat = Convert.ToDateTime(ValidDate);
            var ExpectedFilteredHashtagsNotFoundString = ControllerResponse.FilteredHashtagsNotFound.ToString();

            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).ReturnsNull();

            var result = await controller.TrendingHashtags(ValidDate);
            var NotFoundObjectResult = Assert.IsType<NotFoundObjectResult>(result);
            var FilteredHashtagsNotFoundString = Assert.IsType<string>(NotFoundObjectResult.Value);

            Assert.Equal(ExpectedFilteredHashtagsNotFoundString, FilteredHashtagsNotFoundString);
        }

        [Fact]
        public async void TrendingHashtags_CalledWithValidDate_Returns_OkObjectResult_With_ListOfHashtags()
        {
            var ValidDate = "07/21/2020 12:00:00 AM";
            var ValidDateDateTimeFormat = Convert.ToDateTime(ValidDate);

            object[] dbData = { new { hashtag = "covid", count = 13 },
                new { hashtag = "summer", count = 8 },
                new { hashtag = "quarantine", count = 4 }
            };

            var list = new HashtagList { TimeFilter = ValidDateDateTimeFormat, TrendingHashtags = dbData };

            repository.HashtagRepository.GetTrendingHashtagsByTimeFilter(Arg.Any<DateTime>()).Returns(list);

            var result = await controller.TrendingHashtags(ValidDate);
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var HashtagList = Assert.IsType<HashtagList>(OkObjectResult.Value);

            Assert.Equal(new { hashtag = "summer", count = 8 }, HashtagList.TrendingHashtags[1]);
            Assert.Equal(ValidDateDateTimeFormat, HashtagList.TimeFilter);
        }

        [Fact]
        public async void AddHashtag_CalledWithNull_Returns_BadRequestObjectResult_With_HashtagCannotBeNull()
        {
            var ExpectedhashtagCannotbeNullString = ControllerResponse.HashtagCannotBeNull.ToString();

            var result = await controller.AddHashtag(null);
            var BadRequestObjectResult = Assert.IsType<BadRequestObjectResult>(result);
            var HashtagCannotbeNullString = Assert.IsType<string>(BadRequestObjectResult.Value);

            Assert.Equal(ExpectedhashtagCannotbeNullString, HashtagCannotbeNullString);
        }

        [Fact]
        public async void AddHashtag_CalledWithValidhashtag_Returns_OkObjectResult_With_AddingHashtagSuccesfull()
        {
            var ExpectedAddingHashtahSuccesfullString = ControllerResponse.AddingHashtagSuccesfull.ToString();
            var ValidHashtag = new Hashtag { Name = "Lollipop", Date = DateTime.Now };

            repository.HashtagRepository.Add(Arg.Any<Hashtag>()).Returns(true);
            var result = await controller.AddHashtag(ValidHashtag);
            var OkObjectResult = Assert.IsType<OkObjectResult>(result);
            var AddingHashtahSuccesfullString = Assert.IsType<string>(OkObjectResult.Value);

            Assert.Equal(ExpectedAddingHashtahSuccesfullString, AddingHashtahSuccesfullString);

        }

        [Fact]
        public async void AddHashtag_CalledWithValidHashtag_And_ReposytoryFailsToAdd_Returns_Statuscode500_With_AddingHashtagFailed()
        {
            var ExpectedAddingHashtahFailedString = ControllerResponse.AddingHashtagFailed.ToString();
            var ValidHashtag = new Hashtag { Name = "Lollipop", Date = DateTime.Now };

            repository.HashtagRepository.Add(Arg.Any<Hashtag>()).Returns(false);
            var result = await controller.AddHashtag(ValidHashtag);
            var ObjectResult = Assert.IsType<ObjectResult>(result);
            var AddingHashtahFailedString = Assert.IsType<string>(ObjectResult.Value);

            Assert.Equal(500, ObjectResult.StatusCode);
            Assert.Equal(ExpectedAddingHashtahFailedString, AddingHashtahFailedString);

        }
    }
}
