package me.adarsh.godspunkycore.features.entity;

import lombok.Getter;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.dungeon.bosses.WatcherBonzo;
import me.adarsh.godspunkycore.features.entity.end.EndermanStatistics;
import me.adarsh.godspunkycore.features.entity.nms.SNMSEntity;
import me.adarsh.godspunkycore.features.entity.wolf.WolfStatistics;
import me.adarsh.godspunkycore.util.SUtil;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class SEntity // 3, 4, 5
{
    private static final Skyblock plugin = Skyblock.getPlugin();

    private final SEntityType specType;
    private final LivingEntity entity;
    private final Map<UUID, Double> damageDealt;
    private BukkitTask task;
    private BukkitTask ticker;
    private Object genericInstance;
    private EntityStatistics statistics;
    private EntityFunction function;

    public SEntity(Location location, SEntityType specType, Object... params) {
        this.specType = specType;
        Object instance = specType.instance(params);
        this.genericInstance = instance;
        EntityFunction function = (EntityFunction) instance;
        EntityStatistics statistics = (EntityStatistics) instance;
        this.function = function;
        this.statistics = statistics;
        if (instance instanceof SNMSEntity)
            this.entity = ((SNMSEntity) instance).spawn(location);
        else
            this.entity = (LivingEntity) location.getWorld().spawnEntity(location, specType.getCraftType());
        this.damageDealt = new HashMap<>();
        if (statistics.getMovementSpeed() != -1.0)
            ((CraftLivingEntity) entity).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(statistics.getMovementSpeed());
        Location move = this.entity.getLocation().clone();
        move.setYaw(((Double) SUtil.random(0.0, 360.0)).floatValue());
        this.entity.teleport(move);
        SEntityEquipment equipment = statistics.getEntityEquipment();
        EntityEquipment ee = this.entity.getEquipment();
        if (equipment != null) {
            ee.setHelmet(equipment.getHelmet());
            ee.setChestplate(equipment.getChestplate());
            ee.setLeggings(equipment.getLeggings());
            ee.setBoots(equipment.getBoots());
            ee.setItemInHand(equipment.getItemInHand());
        }
        this.entity.setRemoveWhenFarAway(statistics.removeWhenFarAway());
        function.onSpawn(entity, this);
        if (function.tick(entity)) {
            this.ticker = new BukkitRunnable() {
                public void run() {
                    if (entity.isDead())
                        cancel();
                    function.tick(entity);
                }
            }.runTaskTimer(Skyblock.getPlugin(), 0, 1);
        }
        if (statistics instanceof SlimeStatistics && this.entity instanceof Slime)
            ((Slime) this.entity).setSize(((SlimeStatistics) statistics).getSize());
        if (statistics instanceof EndermanStatistics && this.entity instanceof Enderman)
            ((Enderman) this.entity).setCarriedMaterial(((EndermanStatistics) statistics).getCarriedMaterial() != null ? ((EndermanStatistics) statistics).getCarriedMaterial() : new MaterialData(Material.AIR));
        if (this.entity instanceof org.bukkit.entity.Ageable) {
            if (genericInstance instanceof Ageable && ((Ageable) genericInstance).isBaby())
                ((org.bukkit.entity.Ageable) this.entity).setBaby();
            else
                ((org.bukkit.entity.Ageable) this.entity).setAdult();
        }
        if (statistics instanceof ZombieStatistics && this.entity instanceof Zombie) {
            if (statistics.getEntityName().equals("✪ Bonzo ✪")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTY4ODMwNTAyMjUzMywKICAicHJvZmlsZUlkIiA6ICJkNTA1NTc0ODYwNjg0N2YyOWQ4MTg1ZGRkNzhkZWNmYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJfX0RVTUJPX19fIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzUyNDliZmNlMDM1ZTI4NzdiY2IxOGU3ZjIxZjNjNjgzOTM4NDdhNDgwZDYwZjkyZWQ2MDEzMGEyZWY2ZjNmYzAiCiAgICB9CiAgfQp9", "q9kbi3EVVmbdlVTBsefkVN0y0XGcSuqi4MGRaew11waopAbaett7cZrZRky23ksqqKzNWRsOIx7cDvbcpV04NLaZj/H4HcYgsXGKigFX/72k/M6t9sGxZht7CMLfi9aRYvrZSI9ngTb+SID3ZyrZUaqFnROZKU6qUNaWJrR1qCqv6+5m43WHMS/7ehnDJyWgalGCdJGnT7x6JJaM5jMAERQe3z37mbk5tUxIS3VSoYxovaekQhX9J535M4kkunY15xG6rPrODFiZH+WOolccg5XNiMt5ghA5DxGXnyz2qz8kg3mHVxJ+ETcczOKLDhAVDM9stBHRzpABeC47YcLaK1ZRKaAnkbAbiPx2UCHfUQtz7q0S47Dt+lTkKF51Y6QCnt5wOuYurONE05bEWHqcTgW+cBtTYlXWaQFTc3HCrGl2HWbEtqH1cUGX/bprV72ggICNo/oDhkJIiM9regyByuqLqHI/pGPvHxHSOG8hNQykiyuYuazbrSt+kbZpn2bipHL70NcDqS2Iq944dyDn9MkTp3M8NaqmIYfDs8h6gZ1phCNFemHWtd3qOJvKfhOeAJyEyNIta7g4yvsw/QsqU59GB6MDAClvi9QY3azPUYat71c8zGAAywclRu0zR2P06lcDln0AFGkO06GCG4e8Ivm9S1RhEOTJV6rYp/ITzNI=");
            if (statistics.getEntityName().equals("Bonzo")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYyMTEzNDcwMTk3MCwKICAicHJvZmlsZUlkIiA6ICI5ZDIyZGRhOTVmZGI0MjFmOGZhNjAzNTI1YThkZmE4ZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTYWZlRHJpZnQ0OCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS85MWU3OWY3ZTYyOGYyMWY0Mjc2MTBjYzZjZWQwZmYxNTNlMjE4ODBkNjFjYmFjNjczYmY4NjJiMWQ0ZTQ0MjZiIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=", "dj+mS77dCJC2QrkccHatGa3Z8RzrAycthJ6w3T2F8yAxdYnHNsdf6m+K7+L3hoEIqtzktgyKj/rcA4032Oklmp8doxLmFAvzyKbnCuO4yYt4xGJo2mwt1ZXkOv/saoZeV/lIOW0JlBtL+7K+mUgcxcGbBhZNl3i4QMyWQGqPHoAOXKU8pkfORdYjFS+eEVltWL463m/hc//5brrrxBWKjuOg9XEUWERIeV2S4KicDvjY9DTcxiutckvH22t71JKddW2DMk7XfYsASerItk28z8zhbseaHL5v7GsWW7hmWCNiw0teoaWBtsq0Hlyo+qV63MCdxJNJQDR1UeilL6ZfsNSKt0av5bUrJLaVOU1CtGqRueCFABwBRb6zFU53M6F1feCtoODhlLbB8G8xP8L2NuM2qcuS6nv7pIR+5youtKzUjhVupxf2Fj0xSQiDtYV4/QXPvP9GcHiMsi8yh/h7mtc802TwG4LGA6mvb9BNOAuXNkWCAcBo2oxQbIYR5LVw2xEyCjCcdjIXlxjAMbKW6TP37BFBgDVaXocS6KmEQ8jCx+2B3LHcXFmT2p+RGFANeIaeewtrwyd7Cm5KWolhwG1WSJASthJYo5sa38q9NBobD37aBkYgKOnjGXR6PhKbAdQEUkQZYifnjX4XycVDHdgWpzUO+F+/fDQ4i1Q36eI=");
            if (statistics.getEntityName().equals("✪ Scarf ✪")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYwMjQyODY5MTU4MSwKICAicHJvZmlsZUlkIiA6ICJiZWNkZGIyOGEyYzg0OWI0YTliMDkyMmE1ODA1MTQyMCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTdFR2IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdkZTdiYmJkZjIyYmZlMTc5ODBkNGUyMDY4N2UzODZmMTFkNTllZTFkYjZmOGI0NzYyMzkxYjc5YTVhYzUzMmQiCiAgICB9CiAgfQp9", "XeJFpael1mdy9vufsb7PRNbXIg5asyryrmhk+kKiQvfpT5wUDuFY6oxas7+IHqRYN3wSGHj0cLh6b1iiZias6lpVY+4Lqvt3Go/Mwwdu+JCh3g44owrActw8pMXoOAmxHSnX2melVCSt2Y1qZvdxVKOs6ENUtx+9590D3Dc+GxdlzE5+554EMbDLYOWtQA69LC9JeeO3rsVW6j7YSVbYkHzfdFXo1EjKpoKO2FkKxFwn3NxJ+TgDFc1Tq8fC+DlqhQ23RVzyo/6wH4eOzPzd1hMzNna/n32LEtwTkIqcrvpFG/Km/35P19jUK3tCqNSDdDxJR41j459lCz+qLORAAlPcxUPt+0MxTZANgxGNovwrT1naHLPAy/EtIh8We9kWfmeVQCCoy9Wb/E1LvOnfgrP0xi04ddAgRkte2s8OyR8NbTSKhthwBzEKAwOjUG8fKZ8yGl3dVMYGHF2j/lgTCIGiDOQHBmaIsGogsmaMBoMXMSoWzyteZ/uosJnAN7Y5aUNI7oZmo3yN0P9f+4B4fJME0KAb8Mn2wruYUQIDt95NdQYKlnaJ/oszddPGH8nC1EiKOrpWZqIti24uVmm8bxqVaE+kNiAsd0YAM5A6bJ/N3h856P+Toe7WRCt5m1mKUMnupZmQqAtj1eQHOEzSI1mEijBOSSl/+9qYQScwxLk=");
            if (statistics.getEntityName().equals("✪ The Professor ✪")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYwMTE0NjQ0NTE4OCwKICAicHJvZmlsZUlkIiA6ICIwNWQ0NTNiZWE0N2Y0MThiOWI2ZDUzODg0MWQxMDY2MCIsCiAgInByb2ZpbGVOYW1lIiA6ICJFY2hvcnJhIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzk5NzFjZWU4YjgzM2E2MmZjMmE2MTJmMzUwMzQzN2ZkZjkzY2FkNjkyZDIxNmI4Y2Y5MGJiYjA1MzhjNDdkZDgiCiAgICB9CiAgfQp9", "LGcs6Tm1STjYmX1LsWfC92Htq7ukJ9ZLS+V2iHOUP8phEXACVbpHlgWiKV+NyP3z6CLk013EIK0W12DSitYYWSJ3iouDm+3MnEW8UwlT7CwPajwFgiSlVZfVYuzYsoYoRmoe4mHbGTMuSi5JdAtiMtK3F3lVSRRDZiNghLWDeOBRVpIFlGH/TQIiKHy6wTb0DsrpDt0F9Vuy9PI/UqnZwytQpakc+wTZXUWQMdT+5AVg0z2NAShVzx5+3LHBhsCbwNgbjHJu5ii9YAjBtJiJJcx1r5TcGDWOcCvb1XNoMakTw1UJ8t73ps+Qs2LxkXiF1NzOYXF5nRubVfn4105p/J/2pOcHCaeQL9IPJIbEdVu1dFuq3RbXc/SZZmukadBgV1j0l070MD0F/1/EPn20tjc2wF6rJq4jV1NBAD47zGMkWNKu/CkE5i/+Yjfyiqscw2JvUnmoBy7HQXVX2xtStOjgw4IKEgbxjPAnuyNFo9K5KVPVBtp0decg8tKnpf4borD4+g62hULAvzWUC9qkLNzDCWNzWgfCw5s/dCx4AJRuw/Vi64P8jeaijbWaEvqU+PaBrSPkfME2zVbmVtNgPVx2W0qu7sdjj6UuWMoNBtc4UDF7zE91k4jqPPrj/CmuGPOBgovGDWFCoUExX8P3w1lWpfkcakSp4Ll6giuweAw=");
            if (statistics.getEntityName().equals("✪ Livid ✪")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTU5ODk3NzI1OTM1NywKICAicHJvZmlsZUlkIiA6ICJlNzkzYjJjYTdhMmY0MTI2YTA5ODA5MmQ3Yzk5NDE3YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVfSG9zdGVyX01hbiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jMTAwN2M1YjcxMTRhYmVjNzM0MjA2ZDRmYzYxM2RhNGYzYTBlOTlmNzFmZjk0OWNlZGFkYzk5MDc5MTM1YTBiIgogICAgfQogIH0KfQ==", "fCI5+Nf8bAVTXIu1YRb5NV+GakbwCoKjBn7tHh5P4SqIOlMXYFGRM6xo5+6dSTtK9B+z5gGGqImkV1yQPbCOy8wWuqPWhltubb/DHeD8J1dBAGlK73gyjSKsDGE4C9qp9zf7DV6prZ380VNr93X/MvcE7jX3lHjW7oQUuhWbbQwTn05YGGyyBpWWKnQr53rvJL8mZI3fM0HprYfrCb4jZ0gNJRbMN4L4L4vt/t3dvUrmtVtDpNTrztPIz/TNjEEBhfQa4svNv9LUzeIRrvAfRzOVnPMsaJqkeIDj45/x39//NtUuWhoDP23oaAwtKoKgqRsSWHJ6E3NOQeYRK0aRUGqjIoVCJkWnm/aEcNvB/VySnKWloXIl5Oe3aNcFPj5/j4EHIzRq+2tbF2mF4bwMKHCr0EHde8ElG33r1kX82q/kWQmJ0DXC5tKgCwYeKiZOoUvwrE5qUiSibzBFHewnZJqaSHPLAt8iV3EGQJE7XDrtEUA43THNspnpKJ/xvBP1JP0gtO4raYi2HWgOMYTvfXd6ARcCd0Fy6P8dxJSAOFg5t2w0JjtbT/WG+rXdpbztpMzTB/GJy9EDT0jasTofO4r4KbUAy4MUPFa6zMXrJwGisDFd6/fY2OXlE9O9zIGNDRN4BvToSWuvnKItkjU0KMqVWAXVUAfQYsOXmBWIYpE=");
            if (statistics.getEntityName().equals("✪ Sadan ✪")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYxMjAyOTExOTA2MiwKICAicHJvZmlsZUlkIiA6ICI5ZDQyNWFiOGFmZjg0MGU1OWM3NzUzZjc5Mjg5YjMyZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJUb21wa2luNDIiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmEwNmNiMGM0NzFjMWM5YmMxNjlhZjI3MGNkNDY2ZWE3MDE5NDY3NzYwNTZlNDcyZWNkYWViNDlmMGY0YTRkYyIKICAgIH0KICB9Cn0=", "mpSbfgDmWvoHASfqQ+poj2b4Y0QEZYh4QlqcCqHrZ4DNKY7mIenlbY2s7Ptmhb46dONt5OVfHb1pDLDlCPnYP9QYDXhl/wR99wxA4F7HHjs1g1omvZBfGRCvwHU/Bc3aWhjlaKZCVotf0snzrPTWIHFYnQoVLnhXoz19b3SQfdztIipZoZFKgMxwM2l4y+hBS9p7b/u2loz6/kVLBiLxzzYtAayF+ekma+bWlQcqhdsaf/BAJJSjh/UtipZLvAo4L2E2JlBsoKhj9PVSRVk4eAS1KE7p9Dupbrr/Ypj4bYVpUH5KhMJlQn7vCGoWILwd1NjFWk6KVlGUCag8/3pE1BNeD5d3QOfiVCkFH/rofRfS0/w0Nv8ROK0JQP/cFaAQ3kQ2ilvifF0kzPiA1M7si22lbXGyLqhQAVFsNSgKIU0Fe2qfD536Rr+kkBc/sVAzfVh4ajfsOXtMuMoZGIDJULpA1RD9qsybGvl7kkVQd2jPzlvZD8Ef8ZW8wr64Lu+/zZEj30zISIKZiwIsMKM2vOO7eqbfTs+tu0BNKKjiRg7uLF0qhyCpQrlJENzFud04ZiaTyI1Btt2LpOHQmKASWfg7/TEr8rPVPWiVqRBPCpHe5xJlAtQc2+PrtBO8u+qG3TTRKVci2a+Mpx1SwuPtMY2ZRj1NmYW3yBuu9pQnvlg=");
            if (statistics.getEntityName().equals("Lost Adventurer")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYwMTgxMzk1MzcwMiwKICAicHJvZmlsZUlkIiA6ICI3ZGEyYWIzYTkzY2E0OGVlODMwNDhhZmMzYjgwZTY4ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJHb2xkYXBmZWwiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZhMDM4M2E1Mjc4MDNkOTliNjYyYWQxOGJjYWM3OGMxMTkyNTBlYmJmYjE0NDc1YjRlYjRkNGE2NjI3OTZiNCIKICAgIH0KICB9Cn0=", "UWEpro7nRuOTopH9XzNksRQNC1Uq+vtjGkmb7/x8gsVjD3ealtJDZZvoe1Mi46ImNFnJs1EiEWetQKBQBAn1IYT59N2Xp1HNP1kseQDSFCnpF60eAxnAfZbClN6+8o4/c8PVif7ohmh3RG9X0mvX83FM7fe2nd5jchyCeIV591HFQiOQwDgMH+YFAVr/nwPk6HYn7ud0sGDz8aDnKYw4JkxMUmPHL6YKBX1cWQYZ1ot9d15uhHvgmV1vTx6ezTF0GHfsVuCXyfwVK1g2zyK7vZqpaRy+lMdNjiq1rYF9OncyJ0auqAOlsQMlfgDkau3fDiZ7fDr68arx9UvL9nAmz2xyfQ/qF9nXtuBUFIEkVbVpvs3/SA3SYNm9sO4JmQv1gcUP0nCCj+ZaWUC56yACoUTId+WnYDjzHfyMKR1+Td2z+anP6cdlaT1N8XsQEUPkD6Z8E7kuJjBtvq0nZPc92ndvie1lDD9bfgtV0TXF0o750+AzZslx27zhdioNVsjy5o2XUn6PNDr+4uNOQPb/AOSxDgu8mjTTEQmOD2UHBrqsXqnnt6CAwiB+QNi4VOhvQSa9C6CKFuvNyH2zBk624NcUp4SIqrx6XVsVNa3gXCURSJ61Ri+TRtOXxceMoH7ih2u2JVPU3K+fHqURN7guMEFeQpx4nXpwQkfhETDkrac=");
            if (statistics.getEntityName().equals("Angry Archaeologist")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYxMjAzMDY5NDA5OSwKICAicHJvZmlsZUlkIiA6ICJmNWQwYjFhZTQxNmU0YTE5ODEyMTRmZGQzMWU3MzA1YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJDYXRjaFRoZVdhdmUxMCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jNDhjNzgzNDU4ZTRjZjg1MThlOGFiNTg2M2ZiYzRjYjk0OGY5MDU2OGVlYjlhNjBkMTZjNGZkZTJiOTZjMDMzIgogICAgfQogIH0KfQ==", "h0EcebQKYgqarHvlkbkkkRN798ir/crHJD4PUtLWNgohxOCk0WbtPu5YxQpmCL75Y6I2Y0vVQvic7x2r4vfMUu5z0O5dfjUXwpXQ6zWYdmHIbeg796EqUsdr1VJlPHMY/PVYle+NoYflwssIXYqLOWqswaBB4cz6qfyinujYoU6wVhGbONns7h/mpCM1r+gyua0hP9g+kjgslGebpDtkQRtv/kZpJ5+19cM5KT12KmjBGlTwsmiP+RfEINt5oGv2p12wqwv0CC5TFqB+/SM1yjYcEdWXQfzmsnC9nzIfgEHpNquKiX2pcGfVPvKgjkkLkO23nnQ0e2KOfIhLKHlyHcESd/lwGP9Ea/i+JVtZMEMUmuU3lQU+ywDMCQiGNEnB9MFlDdA6LBc2mwZKYShyQNgEveXxV2V1j8dt5ctKe7ANBMrCKXRjIO0TcHv2q/PJ9GwEuSfRNwdZp88gkbb79VV+7R4nkzAzEmNpRUxpB4P0qYDpMNCaC+NYEjHrzUr3hiD3tyHQzWHqvOJYYkor5kxGBoE19lZNxfVOEv9K6dIiSAPAtyYbRc9PVL9DUwlshfQO+kYwymSfZqVqW8CUafIA2NtIpIshsuOigqPMYIJv/p1HfGZVSGZ2B1Zmb/DQ9QoTLPqv+ExZ/zMMAqLQB+aB1DL5qfMABNOYhyfSQ2c=");
            if (statistics.getEntityName().equals("Shadow Assassin")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTU4OTEzNzY1ODgxOSwKICAicHJvZmlsZUlkIiA6ICJlM2I0NDVjODQ3ZjU0OGZiOGM4ZmEzZjFmN2VmYmE4ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJNaW5pRGlnZ2VyVGVzdCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8zMzk5ZTAwZjQwNDQxMWU0NjVkNzQzODhkZjEzMmQ1MWZlODY4ZWNmODZmMWMwNzNmYWZmYTFkOTE3MmVjMGYzIgogICAgfQogIH0KfQ==", "Zc+egPfvdkkutM0qR13oIUCXYuLIRkXGLuKutWxSUbW4H7jujEIQD+aKW+Yy9JekTbaqehvp+OArXMkjRs9h8o0ZGAJY/xlXF3OVzfBA7hIvrtx7cSaIRIr5pfjcBCUe0m1l8shByayaCtu/q11QZzZCX1+ZHKgghG9W95EnkmyAESHNjIXFBCMxPCElGfjEIsKwdt48NIlDiCmx3pUSCr3AnL8FvHrG4CMNZK+hhMStOV8nLq7l6MppsUUmRWkL0DVDTEh9BHzAWw3pBOvwP3r9Ax/5amBDrB1sN8vSa/bfuMxlxH11UGt3kb04SOuxYuMCCSCzKq0xSzlP5H5HfW3wSSk9T2zcpyEZgsIud28FZzBjcdgB+Umq0Cp7IybAi6xFbjC8zNgh+y24sNv6F4XJzv8v5eB1AwUZXStDrqrIpTb1XHIJurRNBbyXh3q8XuR2ECmpZAwupKtxWDo5og6IbigQEjKFjMrmvgnUd1dukcdro+w/p2IgmGHVXoR6jtN1YNnpldILDJiql8R097Nco3wU0crU5M1qfqkHHEvOOrf7iOZRF+psNaiJSZuBNmmTdS+13Q+nNwoTfGERFb8Em3YxKFs5j9l4a7HxbW2YvH93sGHCxuPgd9bXJ9KPh6Yp9Uch1cDB/uF4FfOwN7WMQ8ON7IhAHAegjLththc=");
            if (statistics.getEntityName().equals("King Midas")) MobApi.createEntity(entity, location, statistics.getEntityName(), "ewogICJ0aW1lc3RhbXAiIDogMTYxMjA4NTk5NDk5NSwKICAicHJvZmlsZUlkIiA6ICJjODE0MzE4MmQ1MDc0NjQ5YWZlODRmZDNmODY1NDQ2NSIsCiAgInByb2ZpbGVOYW1lIiA6ICJBWll4ViIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS82MmJjYTA4NTc1MDA0MzUwM2Y1ZGY5ZjdkZWY4MjRhMmUzYWNmYzI3ODQyYmNkMDlkMmI2Njk1ODgxZTgzMmY1IgogICAgfQogIH0KfQ==", "bhkO0Rk1aJcb+mOyjTW8nm+GllNZfWOogf76eXNhKCU+HbCnBa6F4q3Ui6MXfK2yBbmKbizLH+cH04LisPe8LMsxn520U5UBIWbqPjFL/rzVbaDQev8wDCZaI7Jrk+CsOv2HGIwZj4GtJBZW0qxtI9KQSYWcVOsaih+MKzpojNoTYGQaCarIcVpm13zdZAjRJqX+iTlF2/RHlhLiaYjoiO4SiKMB9Goz9OtNEgqtvS3KE1/EXf71gjfRWm2i3HfkO+ifaf48sGyMh3sFYlDWnzyR6AhTbIAez96g/WHYflj6d6Bl3xQiX8ds2PxYpRjuP2msjHpmrV24WfJCgUHpdBBNuTydNFI+nAI1GAp8EMXVsyP/8blj2VLRkCac7YQr2SjPmyGiCAPBmSZJAzTemHjTH+FqE5bv8dfAl0cV22FHMZ1BSw6CDXuvqx2jm/GdhjdpI9ZVRj9m8CUNVNF06Bd1oSlPi4FuION9s7L6El///zmcdO3czhtm0ICd/0zPV5VTFsYC9+CaqG7khXy+nlG7Gd25VevGjFIfKyV1jn7BmE64ZyXpAxzSjrg7rvThG8vaJv6At8bm6Sg9OxENSu1KWdmT1MJWC1lP7SzT1nK30prJlPF67bNEmP/kpL7TBgwk7UNVRkHnoV6JtgIGAqMEayzo5kmQ75zmUY4kXGs=");
            if (statistics.getEntityName().equals("Undead")) MobApi.createEntity(entity, location, statistics.getEntityName(), "eyJ0aW1lc3RhbXAiOjE1ODU3NDk4Mzk0NDMsInByb2ZpbGVJZCI6ImUzYjQ0NWM4NDdmNTQ4ZmI4YzhmYTNmMWY3ZWZiYThlIiwicHJvZmlsZU5hbWUiOiJNaW5pRGlnZ2VyVGVzdCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjhkYTg4YTI0YTMwZDlmM2NiZjZkMTdlMmYxOWFjY2M3YmNkY2E3ZmQ2MmQyOGY1NzJkZTg3MTg3MDIzYTU1NSJ9fX0=", "meIeVDY4YBFHxT1zzy9aHMmGXsMJEVGDVjbJWHgK/MjHf6VcxcoEs/WDrVAfJMWpNVDbLAP/88g0sRNpZE57wvJBA3M79YJJDW2cgh6l/pDHn4GyNsHgs/kBma2A7BNUvYKEx8FX0ViZONGoHuVJz+NiutkhRoyKTqILm+3/N1PZ5h3+aouDHaPWaVY+iLrF0HrnisOqPfVWu29aqSM3sOvABmGdXqdezC++AZ5+4jsfQ2Ym9HhQ5vT3PLD7MWM0txlv61/opnOGi3NIGmtEcRSMhwpawGGlLa+BC2Qg4+oSHYwMQlhcw2VvYMTYLKT90pKet2TlUlJblbpoGNIPe5/yUuKPiCT8i0odShfX3KS6tBd3KFidncGsbzMyaxFmVI9PGTgcCZo8VuWsp3Urt0MhjBuGlUTy6J9j6wfPBrXkCegw4p0yCCzELh+T5/+YDpSYj9gNqFGVuY2q53+YBqB8d0vr1b0LY/XqNnMoOMgIKYteyTi/shTy8tUODYyZCIOjCsXFG1wvvhImwmVBCRmqOP8DLLqyzBPkGKb85hSa6flp80IuFIyeUsmQJAPA1CCw6lz8v3nkfyThKwkIdbckilZkPKNCI2Wl8QHJGqYvuBFgJfvAr5iM9VCoDdaI2zEGua6HAjNrjBXtgCjZPDKWPed4uHpfK+f9hPOeQdo=");
        }

        if (statistics instanceof ZombieStatistics && this.entity instanceof Zombie)
            ((Zombie) this.entity).setVillager(((ZombieStatistics) statistics).isVillager());
        if (statistics instanceof JockeyStatistics)
            this.entity.setPassenger(new SEntity(location, ((JockeyStatistics) statistics).getPassenger()).getEntity());
        if (statistics instanceof WolfStatistics && this.entity instanceof Wolf)
            ((Wolf) this.entity).setAngry(((WolfStatistics) statistics).isAngry());
        if (statistics instanceof SkeletonStatistics && this.entity instanceof Skeleton)
            ((Skeleton) this.entity).setSkeletonType(((SkeletonStatistics) statistics).isWither() ? Skeleton.SkeletonType.WITHER : Skeleton.SkeletonType.NORMAL);
        new BukkitRunnable() {
            public void run() {
                if (!statistics.isVisible())
                    ((CraftLivingEntity) entity).getHandle().setInvisible(true);
            }
        }.runTaskLater(Skyblock.getPlugin(), 2);
        this.entity.setMaxHealth(statistics.getEntityMaxHealth());
        this.entity.setHealth(this.entity.getMaxHealth());
        this.entity.setMetadata("specEntityObject", new FixedMetadataValue(plugin, this));
        if (statistics.hasNameTag()) {
            if (entity instanceof EnderDragon) {
                entity.setCustomName(ChatColor.RED + statistics.getEntityName());
                return;
            }
            this.entity.setCustomNameVisible(true);
            this.task = new BukkitRunnable() {
                public void run() {
                    entity.setCustomName(ChatColor.RED + statistics.getEntityName() + " " + ChatColor.GREEN + (int) entity.getHealth() +
                            ChatColor.WHITE + "/" + ChatColor.GREEN + (int) entity.getMaxHealth() + ChatColor.RED + "❤");
                }
            }.runTaskTimer(Skyblock.getPlugin(), 0, 10);
        }
    }

    public SEntity(Entity e, SEntityType type, Object... params) {
        this(e.getLocation(), type, params);
    }

    public void addDamageFor(Player player, double damage) {
        UUID uuid = player.getUniqueId();
        if (damageDealt.containsKey(uuid))
            damage += damageDealt.get(uuid);
        damageDealt.remove(uuid);
        damageDealt.put(uuid, damage);
    }

    public void setVisible(boolean visible) {
        new BukkitRunnable() {
            public void run() {
                ((CraftLivingEntity) entity).getHandle().setInvisible(!visible);
            }
        }.runTaskLater(Skyblock.getPlugin(), 2);
    }

    public void setTarget(LivingEntity target) {
        if (!(entity instanceof Creature)) return;
        ((Creature) entity).setTarget(target);
    }

    public void remove() {
        if (this.ticker != null)
            this.ticker.cancel();
        if (this.task != null)
            this.task.cancel();
        entity.remove();
    }

    public static SEntity findSEntity(Entity entity) {
        if (!entity.hasMetadata("specEntityObject") ||
                entity.getMetadata("specEntityObject").size() == 0 ||
                !(entity.getMetadata("specEntityObject").get(0).value() instanceof SEntity))
            return null;
        return (SEntity) entity.getMetadata("specEntityObject").get(0).value();
    }
}