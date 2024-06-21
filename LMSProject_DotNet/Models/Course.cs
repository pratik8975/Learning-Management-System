using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class Course
{
    public int Id { get; set; }

    public bool? HasAttendedECourses { get; set; }

    public bool? IsPaid { get; set; }

    public int Price { get; set; }

    public string? Semester { get; set; }

    public string Title { get; set; } = null!;

    public virtual Assignment? Assignment { get; set; }

    public virtual ICollection<Student> Students { get; set; } = new List<Student>();
}
