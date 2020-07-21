using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Context;
using Twatter_Backend_csharp.Models;
using Microsoft.EntityFrameworkCore;
using Twatter_Backend_csharp.Repositories.Interface;

namespace Twatter_Backend_csharp.Repositories
{
    public class HashtagRepository : IHashtagRepository
    {
        private DbSet<Hashtag> _hashtags;
        public HashtagRepository(DbSet<Hashtag> hashtags)
        {

            _hashtags = hashtags;
        }
        public void Add(Hashtag entity)
        {
            throw new NotImplementedException();
        }

        public void AddRange(IEnumerable<Hashtag> entities)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<Hashtag>> Find(Expression<Func<Hashtag, bool>> expression)
        {
            throw new NotImplementedException();
        }

        public Task<Hashtag> Get(Expression<Func<Hashtag, bool>> expression)
        {
            throw new NotImplementedException();
        }

        public Task<IEnumerable<Hashtag>> GetAll()
        {
            throw new NotImplementedException();
        }

        public Task<Hashtag> GetById(long id)
        {
            throw new NotImplementedException();
        }

        public async Task<HashtagList> GetTrendingHashtagsByTimeFilter(DateTime timeFilter)
        {
            var DailyHashtags = await _hashtags
                .Select(h => h)
                .Where(h => h.Date >= timeFilter)
                .ToListAsync();

            var GrouppedHashtags = DailyHashtags
                .GroupBy(h => h.Name)
                .Select(group => new
                {
                    Hashtag = group.Key,
                    Count = group.Count()
                }).OrderByDescending(h => h.Count)
                .Take(20)
                .ToArray();

            return new HashtagList { TimeFilter = timeFilter, TrendingHashtags = GrouppedHashtags };
        }

        //public async Task<HashtagList> GetDailyTrendingHashtags()
        //{
        //    var TodaysDate = DateTime.Today.Date;

        //    var DailyHashtags = await _hashtags
        //        .Select(h => h)
        //        .Where(h => h.Date >= TodaysDate)
        //        .ToListAsync();

        //    var GrouppedHashtags = DailyHashtags
        //        .GroupBy(h => h.Name)
        //        .Select(group => new
        //        {
        //            Hashtag = group.Key,
        //            Count = group.Count()
        //        }).OrderByDescending(h => h.Count)
        //        .Take(20)
        //        .ToArray();

        //    return new HashtagList { TimeFilter = TodaysDate, TrendingHashtags = GrouppedHashtags };
        //}

        //public async Task<object> GetWeeklyTrendingHashtags()
        //{
        //    var DateAWeekAgo = DateTime.Today.Subtract(TimeSpan.FromDays(7));

        //    var WeeklyHashtags = await _hashtags
        //        .Select(h => h)
        //        .Where(h => h.Date > DateAWeekAgo)
        //        .ToListAsync();

        //    var GrouppedHashtags = WeeklyHashtags
        //        .GroupBy(h => h.Name)
        //        .Select(group => new
        //        {
        //            Hashtag = group.Key,
        //            Count = group.Count()
        //        }).OrderByDescending(h => h.Count)
        //        .Take(20)
        //        .ToList();

        //    return GrouppedHashtags;
        //}

        //public async Task<HashtagList> GetMonthlyTrendingHashtags()
        //{
        //    var CurrentMonth = new DateTime(DateTime.Now.Year, DateTime.Now.Month, 1);

        //    var WeeklyHashtags = await _hashtags
        //        .Select(h => h)
        //        .Where(h => h.Date > CurrentMonth)
        //        .ToListAsync();

        //    var GrouppedHashtags = WeeklyHashtags
        //        .GroupBy(h => h.Name)
        //        .Select(group => new
        //        {
        //            Hashtag = group.Key,
        //            Count = group.Count()
        //        }).OrderByDescending(h => h.Count)
        //        .Take(20)
        //        .ToArray();

        //    return new HashtagList { TimeFilter = CurrentMonth, TrendingHashtags = GrouppedHashtags };
        //}


        public void Remove(Hashtag entity)
        {
            throw new NotImplementedException();
        }

        public void RemoveRange(IEnumerable<Hashtag> entities)
        {
            throw new NotImplementedException();
        }

        public Task<Hashtag> SingleOrDefault(Expression<Func<Hashtag, bool>> expression)
        {
            throw new NotImplementedException();
        }

        public void Update(Hashtag entity)
        {
            throw new NotImplementedException();
        }

    }
}
