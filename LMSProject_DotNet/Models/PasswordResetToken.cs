using System;
using System.Collections.Generic;

namespace LMSProject_DotNet.Models;

public partial class PasswordResetToken
{
    public int Id { get; set; }

    public DateTime? ExpiryDate { get; set; }

    public string? Token { get; set; }

    public int UserId { get; set; }

    public virtual User User { get; set; } = null!;
}
