using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Twatter_Backend_csharp.Models
{
    public class Tweet
    {
        
        public string Id { get; set; }

        public string Content { get; set; }

        public string Posted_at { get; set; }

    }
}
