using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Models;

namespace Twatter_Backend_csharp.Context
{
    public class TrendingContext : DbContext
    {
        public TrendingContext(DbContextOptions<TrendingContext> options) : base(options)
        {
        }

        public DbSet<Hashtag> hashtags { get; set; }
    }
}
