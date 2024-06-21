package com.spring.boot.dao;

import com.spring.boot.entities.PasswordResetToken;
import java.util.List;

public interface PasswordResetDao {

    public List<PasswordResetToken> findAllTokens();

    public PasswordResetToken save(PasswordResetToken passwordResetToken);

    public PasswordResetToken update(int id, PasswordResetToken passwordResetToken);

    public PasswordResetToken findById(int id);
    
    public void delete(int id);
}
