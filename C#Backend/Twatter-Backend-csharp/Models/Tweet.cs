using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Twatter_Backend_csharp.Models
{
    public class Tweet
    {
        [Required]
        public string Id { get; set; }
        [Required]
        public string Content { get; set; }
        [Required]
        public string Posted_at { get; set; }

    }
}
