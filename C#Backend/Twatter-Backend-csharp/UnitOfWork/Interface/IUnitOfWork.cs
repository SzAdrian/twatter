using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Twatter_Backend_csharp.Repositories.Interface;

namespace Twatter_Backend_csharp.UnitOfWork.Interface
{
    public interface IUnitOfWork
    {
        IHashtagRepository HashtagRepository { get; }
        Task<int> Complete();
    }
}
