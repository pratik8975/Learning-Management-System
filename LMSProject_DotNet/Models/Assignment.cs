using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class Assignment
{
    public int CourseId { get; set; }

    public string Assignment1 { get; set; } = null!;

    public bool? IsSubmitted { get; set; }

    public DateTime SubmissionDate { get; set; }

    public virtual Course Course { get; set; } = null!;
}
