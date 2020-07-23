using System;
using System.ComponentModel.DataAnnotations;

namespace Twatter_Backend_csharp.Models
{
    public class Hashtag
    {
        public int Id { get; set; }
        [Required]
        [RegularExpression(@"^\w+$", ErrorMessage = "Hashtag cannot contain special or break characters.")]
        public string Name { get; set; }
        
        [DataType(DataType.DateTime)]
        public DateTime Date { get; set; }
    }
}
