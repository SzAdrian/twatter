using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Context;
using Twatter_Backend_csharp.Models;
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

        public async Task<object> GetDailyTrendingHashtags()
        {
            var TodaysDate = DateTime.Today.Subtract(new TimeSpan(12, 00, 00));

            var DailyHashtags = await _hashtags
                .Select(h => h)
                .Where(h => h.Date > TodaysDate)
                .ToListAsync();

            var GrouppedHashtags = DailyHashtags
                .GroupBy(h => h.Name) 
                .Select(group => new
                {
                    Hashtag = group.Key,
                    Count = group.Count() 
                }).OrderByDescending(h => h.Count)
                .Take(20)
                .ToList();

            return GrouppedHashtags;
        }

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
