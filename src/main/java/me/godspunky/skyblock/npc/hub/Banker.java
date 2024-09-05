package me.godspunky.skyblock.npc.hub;

import me.godspunky.skyblock.npc.*;
import me.godspunky.skyblock.gui.GUIType;

public class Banker extends SkyblockNPC {
    public Banker() {
        super(new NPCParameters() {

            @Override
            public String name() {
                return "Banker";
            }

            @Override
            public String[] holograms() {
                return new String[]{
                        "&fBanker" ,
                        "&e&lCLICK"
                };
            }
            @Override
            public String texture() {
                return "ewogICJ0aW1lc3RhbXAiIDogMTY5Mjk3NzczOTE1MywKICAicHJvZmlsZUlkIiA6ICI2Njg5MDJmYjI1YTY0NDBhODBmM2Y2MjZhYTk0MzBmYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJCYW5rZXIiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmZkODNhY2NhOWFmM2JiYWQ3MDVmNzE0MzU1ZDk0MTA3NDEyY2E0ZWJiZDRjZTkzOTE2MGMxYmUxMGNjZDFhMiIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9LAogICAgIkNBUEUiIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2U3ZGZlYTE2ZGM4M2M5N2RmMDFhMTJmYWJiZDEyMTYzNTljMGNkMGVhNDJmOTk5OWI2ZTk3YzU4NDk2M2U5ODAiCiAgICB9CiAgfQp9";
            }

            @Override
            public String signature() {
                return "mvjZz6+3WH5AuE2YKGJnyFbtfYMUFG2d2bimfJiUPWT8PrfeXurYbLLclpiuk16H/4th5+zMfdnPWRKIyIbWHa0UvSOjnRFTI1xSf5j1UbQKaG8lbwIZUcC6zPU/L/l8ei9X23aUFR+hvgG6OE2e2j4I0MKZ+bcaEcEVnVRQWdGG3XL6FxBcmlXrOtQhnHD6QX+rWgCh8XQYau0nDTXxVbRVCwf3EwjfdEKCic1Za0Bn6tZYv2hz8NvXwrfOQIjXMqFL7a+PPk8sYtdCqUt0oB7N5H+soJaFFPMKegCxF/7Ohk4YaXabVJwYlxxZDjf+ttfolRT8r+YZDlTQegykIKrlw1X9OSJq21vMFthXl+CDpkz3Mj0ClbORRWjzctBJ2Gp5PX5jaE2Fkwjt2kdpf/iurly+LcF5DQ7XD4mSTatUjm9M3nPuj1xjwZ7mmTIyCtwWV0ytqKjkLztEfU5ugx6DwpF1LjIKXW0LGZUHuIX/dYw4OMaNJ3BtQf5B2kwbzUAoefal4duvuF7asQ/xPWZvZr921K4fB1naATX5G+mqoE8RaHl1tX6MD52KBcBY25sejsJw9+m04Pp+ij7qtfGJAWlKemlpqHHKBcny/kCFKajKyEOvNwre9BxRLv0zNVcXAu41B0OClHb0hiHbBzkIpwJBXnnsXWeU0FLdV8A=";
            }

            @Override
            public String world() {
                return "world";
            }

            @Override
            public double x() {
                return -24.5;
            }

            @Override
            public double y() {
                return 71;
            }

            @Override
            public double z() {
                return -58.7;
            }

            @Override
            public float yaw() {
                return 0;
            }

            @Override
            public float pitch() {
                return 0;
            }

            @Override
            public boolean looking() {
                return true;
            }

            @Override
            public void onInteract(Player player, SkyblockNPC npc) {
                GUIType.BANKER.getGUI().open(player);
            }


        });
    }
  }
