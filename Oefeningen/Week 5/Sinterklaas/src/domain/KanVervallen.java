package domain;

import java.time.LocalDate;

public interface KanVervallen {
    LocalDate getVervaldatum();
    boolean isVervallen();
}
