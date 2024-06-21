using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class Student
{
    public int UserId { get; set; }

    public long TuitionFees { get; set; }

    public virtual User User { get; set; } = null!;

    public virtual ICollection<Course> Courses { get; set; } = new List<Course>();
}
