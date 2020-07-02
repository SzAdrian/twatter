﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Context;
using Twatter_Backend_csharp.Repositories;
using Twatter_Backend_csharp.Repositories.Interface;
using Twatter_Backend_csharp.UnitOfWork.Interface;

namespace Twatter_Backend_csharp.UnitOfWork
{
    public class UnitOfWork : IUnitOfWork
    {
        private readonly TrendingContext _context;

        public UnitOfWork(TrendingContext context)
        {
            _context = context;
            HashtagRepository = new HashtagRepository(_context);
        }

        public IHashtagRepository HashtagRepository { get; private set; }

        public async Task<int> Complete()
        {
            return await _context.SaveChangesAsync();
        }
    }
}
