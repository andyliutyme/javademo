package com.example.demo.data.anemics.session;

import com.example.demo.data.anemics.BaseAnemic;
import com.example.demo.data.anemics.identity.UserAnemic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="Sessions")
public class SessionAnemic extends BaseAnemic {
    //region Properties
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserAnemic user;
    private boolean isValid;
    private OffsetDateTime expiresAt;
    private String reason;
    //endregion

    //region Methods
    public static SessionAnemic createEntity(UserAnemic user)
    {
        var newSession = new SessionAnemic();
        newSession.initialize(newSession.getClass().toString());
        newSession.isValid = true;
        newSession.expiresAt = OffsetDateTime.now().plusMinutes(5);
        newSession.reason = null;
        newSession.user = user;

        return newSession;
    }

    public boolean isValid() {
        if (this.isValid && this.expiresAt.isAfter(OffsetDateTime.now()))
        {
            return true;
        }

        return false;
    }

    public void invalidate(String reason)
    {
        this.isValid = false;
        this.reason = reason;
    }

    public void extend()
    {
        this.expiresAt = OffsetDateTime.now().plusMinutes(5);
    }
    //endregion
}
