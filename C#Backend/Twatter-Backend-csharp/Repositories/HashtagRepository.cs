using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Context;
using Twatter_Backend_csharp.Models;
using Twatter_Backend_csharp.Repositories.Interface;

namespace Twatter_Backend_csharp.Repositories
{
    public class HashtagRepository : IHashtagRepository
    {
        private readonly DbContext _context;
        private DbSet<Hashtag> _hashtags;
        public HashtagRepository(TrendingContext context)
        {
            _context = context;
            _hashtags = context.Hashtags;
        }
        public void Add(Hashtag entity)
        {
            throw new NotImplementedException();
        }

        public void AddRange(IEnumerable<Hashtag> entities)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Hashtag> Find(Expression<Func<Hashtag, bool>> expression)
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
