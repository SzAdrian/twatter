using System;
using System.ComponentModel.DataAnnotations;
using System.Threading;

namespace Twatter_Backend_csharp.Models
{
    public class Hashtag
    {

        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
        
        [DataType(DataType.DateTime)]
        public DateTime Date { get; set; }

    }
}
