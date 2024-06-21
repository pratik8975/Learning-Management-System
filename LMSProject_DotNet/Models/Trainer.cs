using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class Trainer
{
    public int UserId { get; set; }

    public string Subbject { get; set; } = null!;

    public virtual User User { get; set; } = null!;

    public virtual ICollection<Trainer> Courses { get; set; } = new List<Trainer>();

    public virtual ICollection<Trainer> Trainers { get; set; } = new List<Trainer>();
}
