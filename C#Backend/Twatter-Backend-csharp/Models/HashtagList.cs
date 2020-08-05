using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Twatter_Backend_csharp.Models
{
    public class HashtagList
    {
        public DateTime TimeFilter { get; set; }
        public object[] TrendingHashtags { get; set; }
    }
}
