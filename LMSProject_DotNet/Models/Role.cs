using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class Role
{
    public int Id { get; set; }

    public string? Role1 { get; set; }

    public virtual ICollection<User> Users { get; set; } = new List<User>();
}
