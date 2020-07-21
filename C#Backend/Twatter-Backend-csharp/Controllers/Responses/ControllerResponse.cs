using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Twatter_Backend_csharp.Controllers.Responses
{
    public enum ControllerResponse
    {
        InvalidModelState,
        DailyHashtagsNotFound,
        WeeklyHashtagsNotFound,
        MonthlyHashtagsNotFound,
        FilteredHashtagsNotFound,
        InvalidTimeFilter
    }
}
