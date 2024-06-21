using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace LMSProject_DotNet.Models;

public partial class Athens1Context : DbContext
{
    public Athens1Context()
    {
    }

    public Athens1Context(DbContextOptions<Athens1Context> options)
        : base(options)
    {
    }

    public virtual DbSet<Assignment> Assignments { get; set; }

    public virtual DbSet<Course> Courses { get; set; }

    public virtual DbSet<PasswordResetToken> PasswordResetTokens { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<Student> Students { get; set; }

    public virtual DbSet<Trainer> Trainers { get; set; }

    public virtual DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseMySql("server=localhost;port=3306;user=root;password=mysqldbt@1;database=athens1", Microsoft.EntityFrameworkCore.ServerVersion.Parse("8.0.31-mysql"));

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder
            .UseCollation("utf8mb4_0900_ai_ci")
            .HasCharSet("utf8mb4");

        modelBuilder.Entity<Assignment>(entity =>
        {
            entity.HasKey(e => e.CourseId).HasName("PRIMARY");

            entity.ToTable("assignments");

            entity.Property(e => e.CourseId)
                .ValueGeneratedNever()
                .HasColumnName("course_id");
            entity.Property(e => e.Assignment1)
                .HasMaxLength(255)
                .HasColumnName("assignment");
            entity.Property(e => e.IsSubmitted)
                .HasDefaultValueSql("'0'")
                .HasColumnName("is_submitted");
            entity.Property(e => e.SubmissionDate)
                .HasColumnType("datetime")
                .HasColumnName("submission_date");

            entity.HasOne(d => d.Course).WithOne(p => p.Assignment)
                .HasForeignKey<Assignment>(d => d.CourseId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK6p1m72jobsvmrrn4bpj4168mg");
        });

        modelBuilder.Entity<Course>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("courses");

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.HasAttendedECourses)
                .HasDefaultValueSql("'0'")
                .HasColumnName("has_attended_e_courses");
            entity.Property(e => e.IsPaid)
                .HasDefaultValueSql("'0'")
                .HasColumnName("is_paid");
            entity.Property(e => e.Price).HasColumnName("price");
            entity.Property(e => e.Semester)
                .HasMaxLength(255)
                .HasColumnName("semester");
            entity.Property(e => e.Title)
                .HasMaxLength(255)
                .HasColumnName("title");
        });

        modelBuilder.Entity<PasswordResetToken>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("password_reset_tokens");

            entity.HasIndex(e => e.UserId, "FKk3ndxg5xp6v7wd4gjyusp15gq");

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.ExpiryDate)
                .HasColumnType("datetime")
                .HasColumnName("expiry_date");
            entity.Property(e => e.Token)
                .HasMaxLength(255)
                .HasColumnName("token");
            entity.Property(e => e.UserId).HasColumnName("user_id");

            entity.HasOne(d => d.User).WithMany(p => p.PasswordResetTokens)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKk3ndxg5xp6v7wd4gjyusp15gq");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("roles");

            entity.HasIndex(e => e.Role1, "UK_g50w4r0ru3g9uf6i6fr4kpro8").IsUnique();

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Role1).HasColumnName("role");
        });

        modelBuilder.Entity<Student>(entity =>
        {
            entity.HasKey(e => e.UserId).HasName("PRIMARY");

            entity.ToTable("students");

            entity.Property(e => e.UserId)
                .ValueGeneratedNever()
                .HasColumnName("user_id");
            entity.Property(e => e.TuitionFees).HasColumnName("tuition_fees");

            entity.HasOne(d => d.User).WithOne(p => p.Student)
                .HasForeignKey<Student>(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKdt1cjx5ve5bdabmuuf3ibrwaq");

            entity.HasMany(d => d.Courses).WithMany(p => p.Students)
                .UsingEntity<Dictionary<string, object>>(
                    "StudentsCourse",
                    r => r.HasOne<Course>().WithMany()
                        .HasForeignKey("CourseId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FKcc42107lsifo5rjyjlhdu6i6u"),
                    l => l.HasOne<Student>().WithMany()
                        .HasForeignKey("StudentId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FKr16q8s9m6kr7xupi4fw9iqpgl"),
                    j =>
                    {
                        j.HasKey("StudentId", "CourseId")
                            .HasName("PRIMARY")
                            .HasAnnotation("MySql:IndexPrefixLength", new[] { 0, 0 });
                        j.ToTable("students_courses");
                        j.HasIndex(new[] { "CourseId" }, "FKcc42107lsifo5rjyjlhdu6i6u");
                        j.IndexerProperty<int>("StudentId").HasColumnName("student_id");
                        j.IndexerProperty<int>("CourseId").HasColumnName("course_id");
                    });
        });

        modelBuilder.Entity<Trainer>(entity =>
        {
            entity.HasKey(e => e.UserId).HasName("PRIMARY");

            entity.ToTable("trainers");

            entity.Property(e => e.UserId)
                .ValueGeneratedNever()
                .HasColumnName("user_id");
            entity.Property(e => e.Subbject)
                .HasMaxLength(255)
                .HasColumnName("subbject");

            entity.HasOne(d => d.User).WithOne(p => p.Trainer)
                .HasForeignKey<Trainer>(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FKmkxcvfr0uu3pwv772aurye5w7");

            entity.HasMany(d => d.Courses).WithMany(p => p.Trainers)
                .UsingEntity<Dictionary<string, object>>(
                    "TrainersCourse",
                    r => r.HasOne<Trainer>().WithMany()
                        .HasForeignKey("CourseId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FKro6avcq0k7gfbag8jrdqvxka2"),
                    l => l.HasOne<Trainer>().WithMany()
                        .HasForeignKey("TrainerId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK4g4qxv5ubvo4a6iwot7p2e3vf"),
                    j =>
                    {
                        j.HasKey("TrainerId", "CourseId")
                            .HasName("PRIMARY")
                            .HasAnnotation("MySql:IndexPrefixLength", new[] { 0, 0 });
                        j.ToTable("trainers_courses");
                        j.HasIndex(new[] { "CourseId" }, "FKro6avcq0k7gfbag8jrdqvxka2");
                        j.IndexerProperty<int>("TrainerId").HasColumnName("trainer_id");
                        j.IndexerProperty<int>("CourseId").HasColumnName("course_id");
                    });

            entity.HasMany(d => d.Trainers).WithMany(p => p.Courses)
                .UsingEntity<Dictionary<string, object>>(
                    "TrainersCourse",
                    r => r.HasOne<Trainer>().WithMany()
                        .HasForeignKey("TrainerId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK4g4qxv5ubvo4a6iwot7p2e3vf"),
                    l => l.HasOne<Trainer>().WithMany()
                        .HasForeignKey("CourseId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FKro6avcq0k7gfbag8jrdqvxka2"),
                    j =>
                    {
                        j.HasKey("TrainerId", "CourseId")
                            .HasName("PRIMARY")
                            .HasAnnotation("MySql:IndexPrefixLength", new[] { 0, 0 });
                        j.ToTable("trainers_courses");
                        j.HasIndex(new[] { "CourseId" }, "FKro6avcq0k7gfbag8jrdqvxka2");
                        j.IndexerProperty<int>("TrainerId").HasColumnName("trainer_id");
                        j.IndexerProperty<int>("CourseId").HasColumnName("course_id");
                    });
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PRIMARY");

            entity.ToTable("users");

            entity.HasIndex(e => e.Email, "UK6dotkott2kjsp8vw4d0m25fb7").IsUnique();

            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Email)
                .HasMaxLength(50)
                .HasColumnName("email");
            entity.Property(e => e.FirstName)
                .HasMaxLength(20)
                .HasColumnName("first_name");
            entity.Property(e => e.LastName)
                .HasMaxLength(20)
                .HasColumnName("last_name");
            entity.Property(e => e.Password)
                .HasMaxLength(255)
                .HasColumnName("password");

            entity.HasMany(d => d.Roles).WithMany(p => p.Users)
                .UsingEntity<Dictionary<string, object>>(
                    "UsersRole",
                    r => r.HasOne<Role>().WithMany()
                        .HasForeignKey("RoleId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FKj6m8fwv7oqv74fcehir1a9ffy"),
                    l => l.HasOne<User>().WithMany()
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK2o0jvgh89lemvvo17cbqvdxaa"),
                    j =>
                    {
                        j.HasKey("UserId", "RoleId")
                            .HasName("PRIMARY")
                            .HasAnnotation("MySql:IndexPrefixLength", new[] { 0, 0 });
                        j.ToTable("users_roles");
                        j.HasIndex(new[] { "RoleId" }, "FKj6m8fwv7oqv74fcehir1a9ffy");
                        j.IndexerProperty<int>("UserId").HasColumnName("user_id");
                        j.IndexerProperty<int>("RoleId").HasColumnName("role_id");
                    });
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
