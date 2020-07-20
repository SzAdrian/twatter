﻿using System;
using System.ComponentModel.DataAnnotations;

namespace Twatter_Backend_csharp.Models
{
    public class Hashtag
    {
        public int Id { get; set; }
        [Required]
        public string Name { get; set; }
        [Required]
        [DataType(DataType.DateTime)]
        public DateTime Date { get; set; }
    }
}