package me.godspunky.skyblock.features.item.weapon;
  
  import me.godspunky.skyblock.features.item.*;
  
  public class DarkClaymore implements ToolStatistics, MaterialFunction {
      @Override
      public String getDisplayName() {
          return "Dark Claymore ";
      }
  
      @Override
      public Rarity getRarity() {
          return Rarity.LEGENDARY;
      }
  
      @Override
      public String getLore() {
          return "§7§7§oThat thing was too big to be called a", +
        "§7§osword, it was more like a large hunk", +
        "§7§oof stone.";
      }
  
      @Override
      public double getBaseStrength() {
          return 100;
      }
  
      @Override
      public double getBaseCritdamage() {
          return 30;
      }
  
      @Override
      public double getBaseDamage() {
          return 500;
      }
  }