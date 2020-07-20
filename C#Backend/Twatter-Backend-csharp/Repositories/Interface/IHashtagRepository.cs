﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Models;

namespace Twatter_Backend_csharp.Repositories.Interface
{
    public interface IHashtagRepository
    {
        Task<Hashtag> Get(Expression<Func<Hashtag, bool>> expression);
        Task<Hashtag> GetById(long id);
        Task<IEnumerable<Hashtag>> GetAll();
        IEnumerable<Hashtag> Find(Expression<Func<Hashtag, bool>> expression);
        Task<Hashtag> SingleOrDefault(Expression<Func<Hashtag, bool>> expression);
        void Add(Hashtag entity);
        void AddRange(IEnumerable<Hashtag> entities);
        void Remove(Hashtag entity);
        void RemoveRange(IEnumerable<Hashtag> entities);
        void Update(Hashtag entity);
    }
}