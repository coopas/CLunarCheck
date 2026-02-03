package git.coopas.clunarcheck.Utils;

import java.util.UUID;

public class LunarSession {

    public final UUID uuid;

    public boolean apollo;
    public boolean channel;
    public boolean handshake;

    public long joinTime;

    public LunarSession(UUID uuid) {
        this.uuid = uuid;
        this.joinTime = System.currentTimeMillis();
    }

    public boolean isRealLunar() {
        return apollo && channel && handshake;
    }
}
