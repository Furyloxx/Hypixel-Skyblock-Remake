// 
// Decompiled by Procyon v0.5.36
// 

package me.adarsh.godspunkycore.features.entity;

import me.adarsh.godspunkycore.features.entity.EnumWatcherType;

public class HeadsOnWall {
    public String skullTexture;
    public String stype;
    public String value;
    public String signature;
    public boolean arg0;

    public HeadsOnWall(EnumWatcherType ew) {
        this.arg0 = false;
        switch (ew) {
            default: {
                this.skullTexture = "";
                this.value = "";
                this.signature = "";
                this.stype = "ZOMBIE";
            }
            case REVOKER: {
                this.skullTexture = "ff184c19e725623d32828a0a4e741e86f135ac63dbc828ff3c8468338f3683b";
                this.value = "ewogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJpZCIgOiAiYzFiNjNhOWM5N2Y1NDgzZWI4ZTI5NTdkZDNiYjY0YjkiLAogICAgICAidHlwZSIgOiAiU0tJTiIsCiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmYxODRjMTllNzI1NjIzZDMyODI4YTBhNGU3NDFlODZmMTM1YWM2M2RiYzgyOGZmM2M4NDY4MzM4ZjM2ODNiIiwKICAgICAgInByb2ZpbGVJZCIgOiAiZGRlZDU2ZTFlZjhiNDBmZThhZDE2MjkyMGY3YWVjZGEiLAogICAgICAidGV4dHVyZUlkIiA6ICJmZjE4NGMxOWU3MjU2MjNkMzI4MjhhMGE0ZTc0MWU4NmYxMzVhYzYzZGJjODI4ZmYzYzg0NjgzMzhmMzY4M2IiCiAgICB9CiAgfSwKICAic2tpbiIgOiB7CiAgICAiaWQiIDogImMxYjYzYTljOTdmNTQ4M2ViOGUyOTU3ZGQzYmI2NGI5IiwKICAgICJ0eXBlIiA6ICJTS0lOIiwKICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmYxODRjMTllNzI1NjIzZDMyODI4YTBhNGU3NDFlODZmMTM1YWM2M2RiYzgyOGZmM2M4NDY4MzM4ZjM2ODNiIiwKICAgICJwcm9maWxlSWQiIDogImRkZWQ1NmUxZWY4YjQwZmU4YWQxNjI5MjBmN2FlY2RhIiwKICAgICJ0ZXh0dXJlSWQiIDogImZmMTg0YzE5ZTcyNTYyM2QzMjgyOGEwYTRlNzQxZTg2ZjEzNWFjNjNkYmM4MjhmZjNjODQ2ODMzOGYzNjgzYiIKICB9LAogICJjYXBlIiA6IG51bGwKfQ==";
                this.signature = "jBhw76KSP11uTcuUizaDUkuM9Zkag6RYWS16BovZaf30GTVpVZq2vDbChI1A5bkpacHpx4YhzIEv7VUmzHEnbO9GSCASQ9tiESYyXV8hWK++QJe1RKVS/KFioLeba6BjGiAhcchIvne1hhjBhlpeMsDrfWD65MXI7+vPvNW7hqfTljpxW3EZk3li7B0iKnJl06K3fLPN8Tw6P/+yUHAVKsbYf1rJjhoq4XZk1nbOi97qzXS4jEe+Cv7AsPJr4ze6fU3DxPi0ADi19zNLX0rb/U4k43z7aMb3qfCM1sSmpQs9WOpHXVCXLK9eJkdygjJUH4aPAIXe+AJuWTT8Sp4l5M7iE1ewRAsdhhtCtMMKuJ0MpwPxf4A3xF4iD740WMRnlhf/Js/Wj/5d+m3O1Qjh5L1gygKCvRK/HTeXjSX0eNVSdgI6uBAbDKXuIunknv6h8qCVLSQvJt3351lf8fOgvOIoRTH6dQcJ3aNqtoTk3ulsHUWvQhjC/kiYAwLkvnVew9mD4qE9vYKOpgnEFbCmZO8/MFNFWx748bXXyFGtApTPPA0dci1yfmj21SLA8+wHiTmzF28eYKslq5rY3TO3RGpiMj+/JbRUiqvrLX86NHsUK/z2eK94ITV0ctVnnjnTFW0urdyAEA1SmVcPbv4gmMER6FqRhxpnuurMoW05+ig=";
                this.stype = "WATCHER_REVOKER";
            }
            case PSYCHO: {
                this.skullTexture = "aa23c8cde2943c84249de8351bc3540be5f8afaaba8b2cb032fc5acad78a269b";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYyNDgzMTQ5NTYyOSwKICAicHJvZmlsZUlkIiA6ICI3ZGEyYWIzYTkzY2E0OGVlODMwNDhhZmMzYjgwZTY4ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJHb2xkYXBmZWwiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWEyM2M4Y2RlMjk0M2M4NDI0OWRlODM1MWJjMzU0MGJlNWY4YWZhYWJhOGIyY2IwMzJmYzVhY2FkNzhhMjY5YiIKICAgIH0KICB9Cn0=";
                this.signature = "vaH5Un/eqsfpTqpGZvCOxBRmVsD3GcxxFhJ6Wb4jtDHn22TVOuFusPkeiNsdfTyJvQmNGGUjoJ73nX4+SoP+86Rg6ZwDqXE/MI4L8Kp68bY3Sk7RgIAQYYxZg+fNCxMUm2pVWajGyvGc0ZohqndreTMTe4piotuxU/KSdXmmhwrXPrbvcO3Lvg6of7/kPrdZHknbwaxLoglc1ikbjczvQKlLh0eyi8wBi2YgkLV5Fta0o0M2xOGHWU+h1oyqwwljmLB5FyMwJWPTnWqua6qYlBpyxD0CzkqmFjXMjmiPhhBTLYhrPAWt5GrEkwTtLQwhRavN3nEl1casGzfE9Eq9n1jGoHPqr+T8v6lhZu1yDi+HrClT5AoThb+eAUd+MQkS2Jzc94jhZqNafovECQPPiecrJEUsg1uv6R9ey4J8lxJnER4i7NghPsAQYlLcCDG9XFnASkHb8nkJvagft2FBKoaCjSwTBBOVlRjtyHZaC7yPDW7NxBc+4UdJVC+7HvAwpLgm7t3gONYy4tc6RoKDKRxvcUJXUEoBAvPqQ11Sy8kAnTy2z/1zxY5abmrvQ2XynGs0GkbOUpUY2/5atAhLvRAOy/liVkqxg+J5k5Dgzt3wt7e2C9NrrVKRL81sVTwNNFyue61OAshNeSoIYQmCcywxCT/BayuCUaR/GarHJHA=";
                this.stype = "WATCHER_PSYCHO";
            }
            case REAPER: {
                this.skullTexture = "a89f6303af85877610912dc04b8b1e89724752f0a7eea05ab6547e228179c06f";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYxNDU2MDA2NjgzNywKICAicHJvZmlsZUlkIiA6ICJmNWQwYjFhZTQxNmU0YTE5ODEyMTRmZGQzMWU3MzA1YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJDYXRjaFRoZVdhdmUxMCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9hODlmNjMwM2FmODU4Nzc2MTA5MTJkYzA0YjhiMWU4OTcyNDc1MmYwYTdlZWEwNWFiNjU0N2UyMjgxNzljMDZmIgogICAgfQogIH0KfQ==";
                this.signature = "JTuEO8eCv1VNcCCslR9J1A/xlWXnGD6gYfXzHJvVl8ghJ22krg9oM5yvtasKQHF4XGUImONUyT39XqSplZTCMyxZk9mamz4rmayCzX58YQIUDMIj9uSQc3B2d0S97TpEYyVt31d1iKmiEis0A45xqFO/dCbMQ0QrUATC6YdK0Rt+X5orYjnGTF8ohZGBN1zQXcqO3sqLGXsB+rdpA3HaZGeYZIf3iz8Jds3lRQRQDAxz6/YKQWGFkCOThCPnFF19KXwEmx+FTMS/zIqEIP9m/Pv9UsKDTmM68T3LmzhJK77VOB5kBmbsmzGzDrHj/5s1K4DrnPwLdgEIK+y0tSQ5dcKVchnqwzfpbA9FUr8jEEWKcQeg3G2C+wayRUM56q4J/qPyFr3tJbnimKGvbAMap5DIMvzl0S3S9XxLrRQi3hgr5o2RhH1ye9pGV55XAGFwo47o36xZbBlhKFqi3NZiyqf+XfCWgD7R2ATVpNrN3jykVEhS676LvMwJRtxxOA/McHmAykPLWp7OsTaZJzvSEEFk1LtarJC50feCtA4Hq5ClxvSfXC/Ny2+cfqv9KWIdoUQKAG7DZ9kCvVDitwDW+eBQoZqgaAJ/UTzfZ64xnmDAYefgydCl+ApI8tqFQbadZCgAZfzFQq/Yvq0oRpvZMnOHWXJ+Naib2s9NtWFEDP8=";
                this.stype = "WATCHER_REAPER";
            }
            case CANNIBAL: {
                this.skullTexture = "b5ba76e02cab72fa7d8ac54ceec849976ab0b00a01068d68c266766bf70c3997";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTU4ODczMzQyMTM0NywKICAicHJvZmlsZUlkIiA6ICI3NzI3ZDM1NjY5Zjk0MTUxODAyM2Q2MmM2ODE3NTkxOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJsaWJyYXJ5ZnJlYWsiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjViYTc2ZTAyY2FiNzJmYTdkOGFjNTRjZWVjODQ5OTc2YWIwYjAwYTAxMDY4ZDY4YzI2Njc2NmJmNzBjMzk5NyIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9";
                this.signature = "CWJrw+i4MsfSVoFv4O6ys5nskm3wfk1suWR1dDw36sOYanrac5rkPRrQ3+kbtgWmOVjDL78RnpPVMn/18EVhLAntO59OO27m3x0T8x5LlleMWf7+e7YhtMAr9vjB227mj2Q/+wjq5IxOaY5FKgGDJiIcCBQJdpGbONEAVQdVvL5JcaL6hgyDxBSbKawN784UMhjv9bud3v/stNl8sYI5tHg+QaLK73Rho147c28lKisjbHjVi932WY2xNCSePt7I7jyigj1crbYva35NoKkYv3PXzFN1RUmyljISYR5YJyCTymK5acyu5dA6U7E/tIk12tJPYMQxpMxoM4K051mG7xOGoGgk0c2HbTo2enciFw14btg+/1CuBfvoCEr8eHEKmlMkC2UhCGracmc87on5KLWH5dUfzKK4/ZK3e1U5TJZBt4HDu43GXee7HyuMUwBiriVYxYBKzsfDptOkyd/gcpxeU9EEhTqY3qDC9AOV+wnwa6UhjD+6jRNDDsw/06FE3lCevybBCIuWBWRQhzrVZlcz+gjpLL/ZDssn/oVkW1ni6dOFdPFp2+oG7MmXEjz9iKgrUNddG877Jczv13Tr21AdXOYdHNkurxJJLSwfBvjeWJ65iO6CiRa7zCM4azPF8oO5b9Zv2bMmX5DIlnsXbmNRSF4YvHUpoetG9Igg0qs=";
                this.stype = "WATCHER_CANNIBAL";
            }
            case MUTE: {
                this.skullTexture = "5cccd53f5191c29a9dc8f0170fbdc4e59e66476aae33de27b468f1de1b7cf3b2";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTU5NjM2Mzk5MTY3NCwKICAicHJvZmlsZUlkIiA6ICI2OTBkMDM2OGM2NTE0OGM5ODZjMzEwN2FjMmRjNjFlYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJ5emZyXzciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNjY2Q1M2Y1MTkxYzI5YTlkYzhmMDE3MGZiZGM0ZTU5ZTY2NDc2YWFlMzNkZTI3YjQ2OGYxZGUxYjdjZjNiMiIKICAgIH0KICB9Cn0=";
                this.signature = "skRMOXwFes3amOb2n+DMCMrhJ1G8bi/E7JLhTYjBJ67UHqfBSAr/9gZdN0oOKC0hNc8RNBQlN0QPHgjrKZCRvL04mg9C7hWWX+/+G71QBvxqgdlOfx0/zwmMpF9fPmqKfgGJ+k19/easarIKLIkrzKodi5+k77hOV5xN1nDIm0fBbJLh8bRarIwa91JFXFVllaSpMH5MIcYqY/Ru+7ZytRRpm0mPbY0UYGHQ+gc7L8ypWvn0mKVxveU+BNZBUgambtkmwCbdOBukY6hrptdLqCegQdxQAcIaE3eIyP+R6mN8p+CUPXDDIDo5X7HNZho3Cg+phCFgTXulS1IVzJDdVjd6+7VxiI/AQ2ehpFaPoQaVXaMmw+dXMLWE26ew4yEYaPh4y2d85vooybf9UY8TvYJi+esdE/yMq+HcZ0rGwjRWhKzMlE5Vx8pVbasxupIlkk6QXtdXu/fFIO9yZxuOJZkUCZCzXPeTcpimFdQBgD+a5YPnpgiG0hl3W9qies8NJOyLKpQfE/Fl8DkDAGlmqJMB69mMEl79DH6xQJlQBx+v4bdkJLY7KAHkosVgstofMKCgqWTq/rU/38cMTluOMVuATY0YkIhThb2MxmBqagiql6xhRO8X5ylBgRCxUd8iwLPHi3Vh8Rfy0X0H+QpsetMmJIry+l7YUQ1bQw3hzLk=";
                this.stype = "WATCHER_MUTE";
            }
            case OOZE: {
                this.skullTexture = "925eb41f3c6eec89411fdbab49499706ed2d8942519d66d68ab2bca763b99727";
                this.value = "eyJ0aW1lc3RhbXAiOjE1ODYzMjIxOTQ0MTgsInByb2ZpbGVJZCI6ImI0NWNkYjFmNjNlMzQwZTM4MzkyYmJkNTdkYTliYzNiIiwicHJvZmlsZU5hbWUiOiJBdXRyaXhfdGhlX0dyZWF0Iiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS85MjVlYjQxZjNjNmVlYzg5NDExZmRiYWI0OTQ5OTcwNmVkMmQ4OTQyNTE5ZDY2ZDY4YWIyYmNhNzYzYjk5NzI3In19fQ==";
                this.signature = "IIqp3rsFCliuqGZozd4MCjX8XS+Skkvh9b7ggGRYKmgX0ZtEUA3jDL35KmzkHaAxi5TfxK6DIU/qyla1UNLTbh5sZ2UUw0b8rjDaLRVj329dzGeZmQAVy6Xe0iYoRSaUwXZPfHjKUgrF0NLk1LNqCy2s21HxvpoGHbsdne684lhFxsTZnCwbMXzkQ9S/Z3iBDTWdDELLEvcRD6FUxGPgmQxjt0uoXEZIZKPWp5vLk0J2WOTvMX2aIBLtyRRbCUNM8KW3YMqwwHrsA9o5+EcMToRDQnjus9Z2a3cgSK7Ox6jmg2UzbdcRcwIhtHg8aP2u8wLj0eIO9eRcp6RcCXgo0GGylc9RCwL1bV/PZShVBQsekmyUAtkPy9GnOciwscXisztNliOq2HnCtYuXnU+bkE8R9RBvVl0yFNGHzZuH5Mu3FZDz483Qx2d3vtt5fewk7S246MfpcwyWQGOclCoGaDdqpqVbDmOY3dxALHfV1jM02wK0n20kyPNtNxZkhSzqgW/8iZNQ4SvQCSbj+DsGcju3njSkHJ+u9xRmz+OQrvC2wbzSZ2DI96j5TSNWfIp/KpbPP3i2EWaxKu9ZeiSBJj3W15zmJ5DjWPyj7WM5KHydbKuV59DFtVJvlRByrjxSPyPE98UlEvbiPngU5NjZCBtFa3j8Q4DCOtuANaCheL8=";
                this.stype = "WATCHER_OOZE";
            }
            case PUTRID: {
                this.skullTexture = "e950aa16d96452f0f925d6c88ab92dd6c81ef40c133083b52c26f02a35d434e0";
                this.value = "eyJ0aW1lc3RhbXAiOjE1ODU0MjAwMTM5ODUsInByb2ZpbGVJZCI6IjQyNzY5MGNjNDE0NDRiNTNhMzA3MWJiZDMyMjAxMDE1IiwicHJvZmlsZU5hbWUiOiIwMlByZWRhdG9yIiwic2lnbmF0dXJlUmVxdWlyZWQiOnRydWUsInRleHR1cmVzIjp7IlNLSU4iOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lOTUwYWExNmQ5NjQ1MmYwZjkyNWQ2Yzg4YWI5MmRkNmM4MWVmNDBjMTMzMDgzYjUyYzI2ZjAyYTM1ZDQzNGUwIn19fQ==";
                this.signature = "ANjGOSRqqJqqXziI+ULfUFneK5759sw1T/lkX49FzJUfLUcZTTxU6RNAUsNX1BoPbLZaa9Ig3NK40tcbICeU9oKd4P/3aggpJaOnVG+I5yZiA+TjZMMDmrr+qOuW/Oh2CRjzj0A4Vtvd3e3piADbo+IaedjuBQH/X/yxYmYxna0F2zb07wSjyfXsd+Tz6YTfPdR7dRCLyiZgu/9E+Wt8JcRo0R51fcpudOz3afCuT2ZjN1l+2D2e2HCUDmRouUIE9FfQ3Q5xdwsNgfgbb4PW2/oxX28wPOXN5oJlnZ8N1ejuMMIbmW+syW0reoqKYw9RD6JvcWs89pTHSsnC10Q7/Fg5Y1JFJ895rLzrrEGcDVT2AzV3WK9Gf3UkPUOYBaRxVjcG4rYTB9CVtYmAshp5mnBCnFW2EQHqUzvlzJ/cRWR+1yvDiiy3rszvGXLhpwly1da0QqbUCb85iRcGNsBUQtL2x5E06jn/0XbQPwO6AUOXpJtMe6ErCitP7fbJ5FJlN9JsXMpFTjScSoQE4FFuo6DNh8LA/uvHwwaEgrgklPcilQucTC1ZIu2LYE9uOtznHjc31HJcxGXXsDnLPTISD+RSp7B99RkEgV2ssax/SixBy+Pel+Ty6bjBllqIY/4heYVOAAkFTZfsrNPkssG8NikV9877JJLc2cF8hcI/hZg=";
                this.stype = "WATCHER_PUTRID";
            }
            case FREAK: {
                this.skullTexture = "7d12b2ade413a6cd7cca3c95e961ba9f0ae7165fa41fc7b5d5f094a01240c609";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYwMjY4ODc2MjIzNiwKICAicHJvZmlsZUlkIiA6ICJjMWE3ZjlkZjgyYTU0NjZmOGQ2YjdkYTk3OTA4NGY0OSIsCiAgInByb2ZpbGVOYW1lIiA6ICJuZWFnZXIiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2QxMmIyYWRlNDEzYTZjZDdjY2EzYzk1ZTk2MWJhOWYwYWU3MTY1ZmE0MWZjN2I1ZDVmMDk0YTAxMjQwYzYwOSIKICAgIH0KICB9Cn0=";
                this.signature = "EzXP18PXbjqgCMSB9ATOCizQmed+2aHOGWm9Pu6Zmt0tKO7ZNiHjRZzjmkCxWvvLpio7xPIqOqhPFjtTWeboizr72XkGTOARIFEYoLl1AER3VXo80Y62wrQih0kOj5kiyn/XICaqMjei8xr7y+VmLZYRgAzgwzJbYybGAXSOt8rNprB0Y/LGwW0VMxjdZYfOOXosA5JI0KtBy8Mm58CcZJeHNTYWp4PJm6U5wG8tGxxy5PDI7q5qU1dY3I1Fch+U/XSxEgpCnQYFs3WiRXqV8Jt9GvCVGlD06w5Vy7EcCIIu40xfMXzZNiK54smo3huE5ed67xtBnQgAC9boIVv9IYEyfXZIQeHDn7DK/iwjxci6Y/4MYAHCjRsHVxsoi06+DbsYNiD/RpHcCQbgris7tKiJwY6lo/gMJxFocGTxKgNYbMb7eiHTqbec3SNxtvhWEKfSanHUWXw/WTRZ1D0opmf5srNar8ZokKyeGCoqHmfL/T9HZpHmRxA4PWToj8I2sqSVHtWkRslN8/j7vlU5T3iglXo2v5RuPEt60YiAhlCFkYSzwZckQKTbo4xjxlBXMxX+FMoYn3lnGDbS61xFQlwDBn6BpYQH39bqQTiAxLAUGPRebRtf8Ar5Jxo4bAeJbEcd4SebxqDfWyxjB4j3HppWzHki+hzPTCvUVIGdjXI=";
                this.stype = "WATCHER_FREAK";
            }
            case LEECH: {
                this.skullTexture = "5a79860aca799407c0faa10b1bbcf42998fad4ebcf31d7a214180826b4ac94e1";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYxMDYzMzYzOTcxNywKICAicHJvZmlsZUlkIiA6ICJlZDUzZGQ4MTRmOWQ0YTNjYjRlYjY1MWRjYmE3N2U2NiIsCiAgInByb2ZpbGVOYW1lIiA6ICI0MTQxNDE0MWgiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWE3OTg2MGFjYTc5OTQwN2MwZmFhMTBiMWJiY2Y0Mjk5OGZhZDRlYmNmMzFkN2EyMTQxODA4MjZiNGFjOTRlMSIKICAgIH0KICB9Cn0=";
                this.signature = "tQBYQCwmIgbaiCDMJZIx/m/T9ylQmsVw6Hc/FVkIqSnyUpmT54ybth7Ju2IDk9deb5wbvi/cR2lGf6Zy0CG6Jqk4LILBB65epDP7hVzozmcyofCU04mzia9JNEq87GpYxTGowowf2DIfR8WiOF/rEGaSXEXFNRSZ0u83cZHLQFe7vPtgsNWLd+NykWFV2Ser1v1HvEQ4kcKVi8ewJWPyuzUdvPfm8ZHnRiqQ7d1bKcJCmp2MotfUJ6UP7RjibQZRM/FfiD2tF3HjNfOTGIpg8APybYFjNVF/i6q1rGfFKLUcMjzr7RKjcXwZ0AX0q1LlgzTGHyc1P0FUND5XdR7t5oz1rY2d70uJmivfvk7MxjJ0THDBwJxOaSHT5o3wYPALj7ALBTtlht2yAIxlqAbX8VAWm7nsnUMxMhMtne7fP+RDCsgbUbBlZZqNuJcFk/sGP4ff9EQ0gAUdoQXQDAi6lZ8Shuu1WcRaZmhlP8U2AwmRuzKc1QILM2LJLS0hhlnQf3ThJyspZbrnTK596UfFUL5F5v3iQ0agXFLylBoLjgD29zE9NItt9oxf9exdqoWVIl0oy7IMt2NiOhTv55n9oDZP1qZc4e7Lyg/nu0WiWEJgDhazVbnQzmkJ2jQME9EufmWV2dZPj7K7YAY/JkOhE7XTdzXePuTan2QYginu45A=";
                this.stype = "WATCHER_LEECH";
            }
            case TEAR: {
                this.skullTexture = "c919e5b8d56f062a21d224de14af771e2f55d09b59e7b099d09daa57540b79cf";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTU5MDQxMjE1MTk3MywKICAicHJvZmlsZUlkIiA6ICJiNjM0NmY5MjVhYTk0MmFlYmQ1NDVjNDE0ZjQ0OTE0ZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJqb3N1eXQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzkxOWU1YjhkNTZmMDYyYTIxZDIyNGRlMTRhZjc3MWUyZjU1ZDA5YjU5ZTdiMDk5ZDA5ZGFhNTc1NDBiNzljZiIKICAgIH0KICB9Cn0=";
                this.signature = "jEnhmMDX4AoUBE4bplR0zatqjfKuAzKr1mD00cxgD1xirqt6xU5pe9/7E/+Bz+KLBUojBoBKIr7p4pdazfLbbm+i8csNZTgmi1xnaGTSVJmA0ApfJSpO8I8V5L8DlsHwjcyON+DZHuGQ/j0q8+plu54pvS0DifL6Yu6vMdYS6zcg1lY8Re91+9kze5Xy8Pddjtw+yKp0D7XjMt0CxhyxUTOCUTfPzOHVTAZpNB3qsfuKnS4+TT12xAcMh/7DUkB10fWE/sN8e5Mp1lVkCNwyZDFIvnnxSqDE/qMNVtDt5P6rvZhMfuwQ6uY4U+YG5VTzt0zmJ8rEytslsVIYCL5g8PHNoCGHmqUtD9wypuBIXcEs1ZPl/3AObAhQrjEzKuL0m0lqWKcy4XzeYxYnxmuCin6RIMKJF3jeo/+5wa15K/IW5XXVV1YWSgjGX0BSeyf4a+GY+cKcWaGdCQitvWOjm1KM2+i4XWm5+nw4bqxwy2NYO0h4JThCx6CBuclqt5ASLNNZD8HNOqk/QbZCkmybV6D5Jf5b64TcpnQwZo/id3qSNPdEcS0g+KDpw1KdtsKXdkhJJoXa+MDr3K9gGPvBJe7/swO2fIXd04R+HJ2cjhVzGV3iZI8ZCfzO/C/BLQSuYKBcG+ZYZ55jo/KQlZEWppLdb/lssDirKAftn6skT2s=";
                this.stype = "WATCHER_TEAR";
            }
            case PARASITE: {
                this.skullTexture = "4774871190c878c9a2c4496c1e10257c6c4ea13807d72c15d7ac6ab3a7a9a8dc";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYyODk4NzQyNDg0MiwKICAicHJvZmlsZUlkIiA6ICI5MGQ1NDY0OGEzNWE0YmExYTI2Yjg1YTg4NTU4OGJlOSIsCiAgInByb2ZpbGVOYW1lIiA6ICJFdW4wbWlhIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQ3NzQ4NzExOTBjODc4YzlhMmM0NDk2YzFlMTAyNTdjNmM0ZWExMzgwN2Q3MmMxNWQ3YWM2YWIzYTdhOWE4ZGMiCiAgICB9CiAgfQp9";
                this.signature = "Ap4/ohPM+nfBgsggTnCdQywNf6EPHyiBXWjVQxOcpcKRnpkJo44+9tNRYw2tbwg1iCKBKKMKF+OcKYjl4DAUOy9Jv7xjGvXmp8DTYnaFHEXvLp2Xm/PH1rmLUi8tYrin8o+57Cw9yZxxA7D+mSgytqUrDrUX47nCPar9qOD+qSh02aCRhRjyw071aqpIndxUyxsWyfhYQT2J/YZazDQ95CxnYelxH3sJOHDjxHrjvjOSvi0ODz0RK39EQD1qMHbWULGLkirT3C6w5BhUoa9QwcY19jF2jpvwK4oTR6S4uOqM4upt0jMbgLURdteAMai4nzdfo+j2iaTldyRHABMTRUkF3f8OUgIPjBSsIJ7toJSm/skEBpH5WcA5weEIki6me5tjGagB2CgNvF4dPLRcQdI49vlSX450LDQizZl4OcD0oav7fOTexBABydzdzEk6kQj5CztTgKDI+bJGr+CLPwBSp78+m9lZA2UcK3KMqFR7TzTuH3KU3EL7pn/d/ptBX31DXGE0qXPvTptlibUOgR5G4B+9yl61ZlTk1SoE0f7/BijQ42OT5FAOyoTT56ylelso389L6hxMbfKa3t/p/iEVyrrWq6jsubAEs5GK8ZPV96lTtUIYL1XAdNdIj+csNU/PjcUlME109kaK7oFjpDy3Uj8RIMhtGbK8P62dS38=";
                this.stype = "WATCHER_PARASITE";
            }
            case FLAMER: {
                this.skullTexture = "67237eddaebdbbdaacfa912885560ccdc65da93b4c3d513532868ec23bb5b448";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTU5NjM2Mzg3NzI4MCwKICAicHJvZmlsZUlkIiA6ICJlNTdjZTEyOGRiNDY0NWI5YmEyM2E3NGYxMTMyYTAxNyIsCiAgInByb2ZpbGVOYW1lIiA6ICJXb29kd2FyZFdhcndpY2siLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjcyMzdlZGRhZWJkYmJkYWFjZmE5MTI4ODU1NjBjY2RjNjVkYTkzYjRjM2Q1MTM1MzI4NjhlYzIzYmI1YjQ0OCIKICAgIH0KICB9Cn0=";
                this.signature = "UNptZ5Ip0FKNbMgvDvTolv5QXdJLbDuGY9Fo/No2ojcyAC8XoW4C+g1jP3xGAXGIYL7p4JIrTdu6gg9A/4d2FlZRol23nuNpUy+uLwQ5SEzbvYdzGXuM0JUb2JGsk70XqBi5QSBo66rde1xVwIx0g5toaM9sh5pk3tOC70sk/604uHfzWBWULMrqHrlGVRlPORbmWblX3Az2tSmEyQ8LQJNLzDTEh8l+k8+KvxYPvsSE+s8n0UdA9JEmxzahXnRC8W/R3BTq+an6ueOb2I72k0FoxYqQn1aZuKoyIhOmJrLOezpLqeGoR9xRE58cyFjgNWGTtIMd6jauWzJNRkDZflLTP/ppnrdF6oM5WjKPg3ePfpINQ9BS7xAB0SXSoWrdElhH0pFQkIHt3IfjmyJnwksZo5V7bxhfl/v21N6oS0P1c4pQlUahEqldLUYCqQcswHbYp1nVfghFbC9D6oO34+sLT3rQvRTDWFz4Ve80FeO9MJrI8q7ujOl6DYwBn/O4e6MRY+reisVzmggGYSQsWDOl7r7eKjMIxCxvBQus1y5DtqmTVAwz3cY6igo1lvIFkhwYfazJSwO1Nv0RQs6P8EZVbh058mTWvgF4xfXGzNa3KnDFXk5002ESeQRJRqRkPir6tM35B2TnCGTxzgkpF9rynhwgViwN/f4ef+RNOdQ=";
                this.stype = "WATCHER_FLAMER";
            }
            case SKULL: {
                this.skullTexture = "ad22772f769045fdc5be819ad68b01a97ac04c60886d2ca7afee39b282f7a383";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYwODgyMjczNTMzNywKICAicHJvZmlsZUlkIiA6ICJkZTE0MGFmM2NmMjM0ZmM0OTJiZTE3M2Y2NjA3MzViYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTUlRlYW0iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWQyMjc3MmY3NjkwNDVmZGM1YmU4MTlhZDY4YjAxYTk3YWMwNGM2MDg4NmQyY2E3YWZlZTM5YjI4MmY3YTM4MyIKICAgIH0KICB9Cn0=";
                this.signature = "O+3QVnK4hDYQJ0qP310w6T7HekANQdmiaMHx3Yb+OtHJ5jtxw9Gwh+2wSJH71KsPWgj21NbNe144ePt80/HJRC+fXoQbH9ZRhRtLW+TFGKX36WoDYg0vw97U1PUrOf9owcEOBYMwE4hfiibxm7so0DaGX8+QUMjS/eFXlyW/QyOWt+o0frqFdUthpwPG6VXynIm5ZTv3nMZSrHJqeSeoHC7/Gg+G7DkV2AHu1XRVwzELuEMdj1lWma/JyVN6wUNfAv9aKbK1oQYm8RLDCB1+ry32+8ogByrcBHv8FBGeOfdkrY2EdNpC9AQup1k9myqOIITnO8KWFdnesddJUMYD+pSLxMPYxUdQZfugPQCgA+aon1k+K+GGdt+gTBNUF80x+yIUOye1ihRzrsSu3w56CNMbGbT+w0pzjzSehVLNWSpJWERJBZAaXF+eJmjdj2k3/RImFLjFituM0zQoUQdu63+FqmHtqIj/lBjE0hzvI7+S5fLMqqgBa/ovpPe9gI3FtW5XQJxbq5cRYIMbCLcVTQmNUFBFKMgBXkk2JsNcsHAVJTm8SB/PVELW6pXrQqDUKWlcTXAHEWAL+A2IN8zV5bJFQq6pBxpSyls3y6vevFSZtSTdId4kNvhsITCC1zS/d2yo22RIJ3gV9uH3iJv9e4QE+Kf0KHXpecLKHdH+g+A=";
                this.stype = "WATCHER_SKULL";
            }
            case MR_DEAD: {
                this.skullTexture = "fb3973a752b24a2f3abb003427f6dbe6ca3a61db0a1bcf351c6eab27ec27e50";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYzMTk3MTAyODcyNiwKICAicHJvZmlsZUlkIiA6ICIwM2E5NjQ5NDA0NzI0MmE2YTQxYjljNGJhM2QwY2E5OCIsCiAgInByb2ZpbGVOYW1lIiA6ICJlcmljZXBwcyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9mYjM5NzNhNzUyYjI0YTJmM2FiYjAwMzQyN2Y2ZGJlNmNhM2E2MWRiMGExYmNmMzUxYzZlYWIyN2VjMjdlNTAiCiAgICB9CiAgfQp9";
                this.signature = "eYRlY7vpxU+OHDS7ZSNZoQEd/+eux1a+9GMnyniM5nEW9f3/0I6RwijudgCLr2WzEp0peaxGTjHw08T3pH4MePK5f0TvcQFTdPehzE8wXQAZm9kdz+fqwNSXceo0A7MlEBZhVx55lpqSoPP1ldNNwHS3QxW4IlY/5yxDGhjzfkP6rRwc98wNBi7GbW12svLVid21WHa3HW4nN8b2feCb4QxBrT7e2VZFMGzP/ejEoAyfBsQD1x2PF++gMX74+gN/i9Er4ZrU9paWf1ioIFEwMFT1N/3RHy0GdWIc7v9FurQft3U9QOPI6Y1XLGm8N9cAefCbr5fYhi0PNSZBHpjli9G4HbCHKWikI9hsHWNZOKkdtf5DIoU260oBGJjzcmW4sn3Jyw94VRBe9VrlhNKh5/5bb5FDmaobLwQxzLLU1BFAaTcaU+SNZIJ+vDBAszliwyuq7UqHNuU4KHxS0EO8iHDaQkoanfEpeKQQVA6VVfQcPZOh+erCSp1L9Am3WILJccN8L9gDtGcdxqb+V2hPfq7J2+mwh6Nhm3PxSJgCGiuieaOWPxBJMXaoga9tNmxrshCv4kOEafGlUXBx5r223ReQlHm7DUHvhwFJKZy9h9A+EeHUZcOuY+4ujAX7SI3yDsd6RUCNg4/NoVzPRBvpAh3V8SyTDC/alW63PRHgZ6g=";
                this.stype = "WATCHER_MR_DEAD";
            }
            case VADER: {
                this.skullTexture = "ad67f97d7f821729beb34a82c3f13592b40439fe5248e72576fde7aa180bf77";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTU5MDYwNTQ5NjQxOSwKICAicHJvZmlsZUlkIiA6ICIyZGM3N2FlNzk0NjM0ODAyOTQyODBjODQyMjc0YjU2NyIsCiAgInByb2ZpbGVOYW1lIiA6ICJzYWR5MDYxMCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9hZDY3Zjk3ZDdmODIxNzI5YmViMzRhODJjM2YxMzU5MmI0MDQzOWZlNTI0OGU3MjU3NmZkZTdhYTE4MGJmNzciCiAgICB9CiAgfQp9";
                this.signature = "jfVq1fORXM84mNZ3NsMFqlr5p2jDzTxB96z8SNklfCgx0N33MNJjXnGXSg8Ayr0CBNELu4++0oHKzpGfIlAhFMtle2Wyxcjp8LmPZrXBu8tiypqll6LO2gKWF81VNZRfdr6yj7VqD5RFfDygu5e2t7fnpp3/D+jxwqpt4qLgV2Ewac1ainGnPNrXZlDRzpuZZ5TT123sfA0SRfuHKaMi44Q/jD/lcXQ5UlTZsqPBrmwkzF5/BV0UMIbXjlj2WFteuS4raDyrYvH1pMpMppg29RHM8C6wwJ6mc6umIhXN1Yq2NfZY7v7Qs9y4MOrmu5ZSGae/wuI2RAIgqwDqNCXWEMZN2x1aurClr366ZquSfk8MhSDC3F7BT8fRP1ra0AgrbcAXLl1DRHZHkFnl+n11Ec/8BXo5XUwqu+3OYQu3av/eAqlVnkgeT5SaUZp7e2vPm1Jw4Xp8yLBedVewixVT13ku5DpPkOW4a+xvvVYSWPV77+iAjQpzLen4L95xzy21Kji1DfSUR+6Vm6tGK2oozMELgDBEX6XjxicPI30L+TS6SJkv7pFx+vmTmroZmTg9o4hYyqj3/A0JE7vKXoQgNXPY07zwiHLmyh6AjnxmhaLRO6LCSUhTIP3HrW3a6I7CwHzZaIHXM+hrpzUt0AyQ5RayymBooImjeSV2RuouTcA=";
                this.stype = "WATCHER_VADER";
            }
            case FROST: {
                this.skullTexture = "3260325171a7ba8460830c0eea515c757a665e5b16a14207ba1a3182752bee87";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYzMDMzNjkyMjE2NywKICAicHJvZmlsZUlkIiA6ICIyMWUzNjdkNzI1Y2Y0ZTNiYjI2OTJjNGEzMDBhNGRlYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJHZXlzZXJNQyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8zMjYwMzI1MTcxYTdiYTg0NjA4MzBjMGVlYTUxNWM3NTdhNjY1ZTViMTZhMTQyMDdiYTFhMzE4Mjc1MmJlZTg3IgogICAgfQogIH0KfQ==";
                this.signature = "YrsEAf5EY/wDxeAhUAyt2YKybLZ7jDHQLY2wzDoozf43CGHaHinumeqNhq4YT6pHScZWy4xJdFGyhrEWDwoJMRIMDQnQpaTZwMrIdWuMIU3VGd2wMhrkcJvTR1jEmCUr0TUqqVhnLOVQHv0v+YvJw8NQQjwH0wH9WD5zqOyOMEJ5hJ/gdf+vivvXJqFGMTg28Z+CFMe1m0gCEWiynv2LAZ2+NbLQzkYoacNvs5WO0Zo3YnxgN4ps2VnVULq0vSNC6GEGVkuHp+9dTobEwr8apoYGqF6qTChTpwaIT++TiZ6fY8zGXILNK8fegshuM2R9WyN91Jz/6vPR722Gr8Y6KqwDbIAhW/Jb5Q/F6co6Sf4f8nZgg1TqmKf3ntb5dwvCh+zSixA7H5xLf8pb+kxIQcwb2O4qHlgNRHcX1HIwVgBagOAuLUKYesTftzm1dCgpPkqgNxU/l2qZkwyt9j45ExYKuULwEYRsgJvcvufZjfmotfRG88x7ZReVGIl+5HfMd5EoG7QyR+tfOCDEXp1h2FBEOlM/1CPFXU1tYuRBLyvPWCJU/1ystVt+acU8eZjtAl5GqfskQRKGveVWXeTKHZN9H/yxtSXdHzYtp2lZOzLCdOTmoqLu+0YJUq0F3DFn6QYhtAzIyR4KY8fQyq+0Tjsi3hRz0PjHHgPJLZQAqCg=";
                this.stype = "WATCHER_FROST";
            }
            case WALKER: {
                this.skullTexture = "8421ba5b8e3573ef97beb5b40e15d15b20f30631c4c5330c3deda3047df0e92";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTYzMTk3MTI1MzI0MiwKICAicHJvZmlsZUlkIiA6ICJhYTU1YzQ5ODM1ZTA0OGEyODgzYjdkNGU2MmQ2MTc4YyIsCiAgInByb2ZpbGVOYW1lIiA6ICJLb2luZ19NYXJjdXMiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQyMWJhNWI4ZTM1NzNlZjk3YmViNWI0MGUxNWQxNWIyMGYzMDYzMWM0YzUzMzBjM2RlZGEzMDQ3ZGYwZTkyIgogICAgfQogIH0KfQ==";
                this.signature = "QO0gurRJj7plQVyfoycm7Sfg9g7wPdbKVxtd6R8nlNc+QQBsJ8WdfZKXkhKC75Pjd9edQv3pgnmapDWdW84pLkHV/ZgEhdTZz4Jpof0NYuwecdlmku9ySrRHE/JucK9dOFWPMNjatXHA0/Hv8bI3U/T9AG1dYF7AGG0+JLnrXlzdXsqdpqn1LLjBu1CLF8iS6SBGLgK9q0Q3fbul22KRZI3hVqBJ8Bzkwm0cnMVtLECop+VMEG2A0rjG5ucn8Zm2+CXg7g3P5DWpHUDhZhpRKnYW6YQbz9+SeLzavP2H4P2mya4WyHVSNpmQuLYlRjwp89Pe2mySOHA3IhF39jYJFPoYoZhoqCwsC2h8aY+jySnCScH5whHXWi7OFJpdFrkFAYVsgCYwxYNWoNDb3g9pWNuCrSCkc5wK/hLELsmAQGhlpGiXCiPpq2uRe5Eg2nHGfrnDPyymxdIx7deSsfr/FHJl19jX1C7dz4mbA8HVDlqz5k/aGp3YFvcqCuXKvtUM0L2iubIj6L/hRhu9LJWs2rlzo1fBmX4GNeDnYW656ovWEH9LN4yVQEFr3oYdO6tgur9zjucrOMkWk5kvx5lAX5zMk7Z3kHqpQo8gtUEuwRZz6YWskrWZdg55vQZ8bk1G4n/Z1W1QA4s/OK58OlMyuCRu2dl+kCfnNUql8yzrHbI=";
                this.stype = "WATCHER_WALKER";
            }
            case BONZO: {
                this.skullTexture = "12716ecbf5b8da00b05f316ec6af61e8bd02805b21eb8e440151468dc656549c";
                this.value = "eyJ0aW1lc3RhbXAiOjE1ODc5MDgzMDU4MjYsInByb2ZpbGVJZCI6IjJkYzc3YWU3OTQ2MzQ4MDI5NDI4MGM4NDIyNzRiNTY3IiwicHJvZmlsZU5hbWUiOiJzYWR5MDYxMCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTI3MTZlY2JmNWI4ZGEwMGIwNWYzMTZlYzZhZjYxZThiZDAyODA1YjIxZWI4ZTQ0MDE1MTQ2OGRjNjU2NTQ5YyJ9fX0=";
                this.signature = "puWmCKCe1NJDMKo0JGOSAIqjjCjFM48Y1ukmxNR0mLBSqP+KafZZ6VJPKDQwrwBPCVZ3CsVvlD4CxF6yLOAsXoX/dadFoDrqHcfW6LhecMv8J1KWqJJNna48grtDamXTtc8V/17mewhc8Dlz/96wKpGtmIAf/caSND/GVCD6XYggw8wgCB/L8dI2NeK0F9OOZd299Ku0BY+I1ngo8GBAnwInNLOPgCqyHjESnDHeE8L2SqkKuRy4cEfGM7D3C1tDQgNRqPEBZHPNmgumoA6ThhDTV2UXIKKrQQPAly+jdzAY3A8ezdGvocrp+jxlDhCKCh9N49RLh7w1rOfrDHQNxafdC6zmX0BdkARhwpd3ZMXJoSWscN8DqM1TK1dDi29cHjyHzXrCdgVPZ+ArKrmW2adbgU8c3I/WRlfXYsVmkz92MdVevcz4KJ55gRI4bdRivMXRhEe4giwpEpn0bBjrzeCOtQMygijHCx5zZUYZYjiwLun+qM+EZU3XTC2WGhcUWsfYPrTHoi3O9R7B/3G3rk1aw1NjNrm2zxSfR0Rh22ORtJLMgqJKuyHQ6qSLISoLpGbn7iSlPqwqHQg+w4sT5LNwd0tgfJAG38bUVZpLOBsbQxSck6hsxdTTTMSibXpse+JQWny+Sn+kvKt/amEYjIZClss7nvJo9jBc6HitINc=";
                this.stype = "WATCHER_BONZO";
            }
            case LIVID: {
                this.skullTexture = "c1007c5b7114abec734206d4fc613da4f3a0e99f71ff949cedadc99079135a0b";
                this.value = "ewogICJ0aW1lc3RhbXAiIDogMTU5ODk3NzI1OTM1NywKICAicHJvZmlsZUlkIiA6ICJlNzkzYjJjYTdhMmY0MTI2YTA5ODA5MmQ3Yzk5NDE3YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVfSG9zdGVyX01hbiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9jMTAwN2M1YjcxMTRhYmVjNzM0MjA2ZDRmYzYxM2RhNGYzYTBlOTlmNzFmZjk0OWNlZGFkYzk5MDc5MTM1YTBiIgogICAgfQogIH0KfQ==";
                this.signature = "fCI5+Nf8bAVTXIu1YRb5NV+GakbwCoKjBn7tHh5P4SqIOlMXYFGRM6xo5+6dSTtK9B+z5gGGqImkV1yQPbCOy8wWuqPWhltubb/DHeD8J1dBAGlK73gyjSKsDGE4C9qp9zf7DV6prZ380VNr93X/MvcE7jX3lHjW7oQUuhWbbQwTn05YGGyyBpWWKnQr53rvJL8mZI3fM0HprYfrCb4jZ0gNJRbMN4L4L4vt/t3dvUrmtVtDpNTrztPIz/TNjEEBhfQa4svNv9LUzeIRrvAfRzOVnPMsaJqkeIDj45/x39//NtUuWhoDP23oaAwtKoKgqRsSWHJ6E3NOQeYRK0aRUGqjIoVCJkWnm/aEcNvB/VySnKWloXIl5Oe3aNcFPj5/j4EHIzRq+2tbF2mF4bwMKHCr0EHde8ElG33r1kX82q/kWQmJ0DXC5tKgCwYeKiZOoUvwrE5qUiSibzBFHewnZJqaSHPLAt8iV3EGQJE7XDrtEUA43THNspnpKJ/xvBP1JP0gtO4raYi2HWgOMYTvfXd6ARcCd0Fy6P8dxJSAOFg5t2w0JjtbT/WG+rXdpbztpMzTB/GJy9EDT0jasTofO4r4KbUAy4MUPFa6zMXrJwGisDFd6/fY2OXlE9O9zIGNDRN4BvToSWuvnKItkjU0KMqVWAXVUAfQYsOXmBWIYpE=";
                this.stype = "WATCHER_LIVID";
            }
            case PLAYER: {
                this.skullTexture = "";
                this.value = "";
                this.signature = "";
                this.stype = "TEAMMATE";
            }
        }
    }
}
