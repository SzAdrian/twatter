using System;
using System.ComponentModel.DataAnnotations;
using System.Threading;

namespace Twatter_Backend_csharp.Models
{
    public class Hashtag
    {

        public int id { get; set; }
        [Required]
        public string name { get; set; }

        [Required]
        [DataType(DataType.DateTime)]
        public DateTime date { get; set; }
 
        [Required]
        public string tweetid { get; set; }

    }
}
