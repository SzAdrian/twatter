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
using System.Text;
using System.Globalization;
using System.Text.RegularExpressions;

namespace Twatter_Backend_csharp.Repositories
{
    public class HashtagRepository : IHashtagRepository
    {
        private DbSet<Hashtag> _hashtags;
        public HashtagRepository(DbSet<Hashtag> hashtags)
        {

            _hashtags = hashtags;
        }

        public IList<Hashtag> GetHashtagsFromTweet(Tweet tweet)
        {
            IList<Hashtag> hashtags = new List<Hashtag>();

            bool hashtagFound = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tweet.Content.Length; i++ )
            {
                if (new Regex(@"#").IsMatch(tweet.Content[i].ToString())) hashtagFound = true;
                else if (hashtagFound == false) continue;
                else if (hashtagFound == true && new Regex(@"^\w+$").IsMatch(tweet.Content[i].ToString())) sb.Append(tweet.Content[i].ToString());
                else
                {
                    hashtagFound = false;
                    Hashtag newHashtag = new Hashtag();
                    newHashtag.Name = sb.ToString();
                    newHashtag.Date = Convert.ToDateTime(tweet.Posted_at, CultureInfo.InvariantCulture);
                    newHashtag.TweetId = tweet.Id;
                    hashtags.Add(newHashtag);
                    sb.Clear();
                }
            }
                   
            return hashtags;
        }

        public Task<bool> Add(Hashtag entity)
        {
            try
            {
                _hashtags.Add(entity);
            }
            catch (Exception)
            {
                return Task.FromResult(false);
            }

            return Task.FromResult(true);
        }

        public Task<bool> AddRange(IEnumerable<Hashtag> entities)
        {
            try
            {
                _hashtags.AddRange(entities);
            }
            catch (Exception)
            {
                return Task.FromResult(false);
            }

            return Task.FromResult(true);
        }

        public async Task<List<string>> GetTweetIds(string hashtag)
        {

            var hashtagList = await _hashtags
                .Select(h => h)
                .Where(h => h.Name.Equals(hashtag))
                .OrderByDescending(h => h.Date)
                .Take(30)
                .ToListAsync();

            var tweetIds = hashtagList
                .Select(hashtag => hashtag.TweetId)
                .ToList();

            return tweetIds;
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
