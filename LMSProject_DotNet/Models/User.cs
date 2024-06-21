using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class User
{
    public int Id { get; set; }

    public string Email { get; set; } = null!;

    public string FirstName { get; set; } = null!;

    public string LastName { get; set; } = null!;

    public string Password { get; set; } = null!;

    public virtual ICollection<PasswordResetToken> PasswordResetTokens { get; set; } = new List<PasswordResetToken>();

    public virtual Student? Student { get; set; }

    public virtual Trainer? Trainer { get; set; }

    public virtual ICollection<Role> Roles { get; set; } = new List<Role>();
}
