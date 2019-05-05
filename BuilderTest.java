public class BuilderTest {
    public static void main(String[] args) {
        Hero mage = new Hero.Builder(Profession.MAGE, "Riobard").withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER).build();
    }
}

public final class Hero {
  private final Profession profession;
  private final String name;
  private final HairColor hairColor;
  private final Weapon weapon;

  private Hero(Builder builder) {
    this.profession = builder.profession;
    this.name = builder.name;
    this.hairColor = builder.hairColor;
    this.weapon = builder.weapon;
  }
  
  public static class Builder {
    private final Profession profession;
    private final String name;
    private HairColor hairColor;
    private Weapon weapon;

    public Builder(Profession profession, String name) {
      if (profession == null || name == null) {
        throw new IllegalArgumentException("profession and name can not be null");
      }
      this.profession = profession;
      this.name = name;
    }

    public Builder withHairColor(HairColor hairColor) {
      this.hairColor = hairColor;
      return this;
    }

    public Builder withWeapon(Weapon weapon) {
      this.weapon = weapon;
      return this;
    }

    public Hero build() {
      return new Hero(this);
    }
  }
}

/*
...
@Override
public Builder accept(String... types) {
    return getRequestBuilder().accept(types);
}
...

WebResource resource = Client.create().resource("http://myapp.org/api/v1/data");

WebResource.Builder builder = resource.accept(MediaType.APPLICATION_JSON);
builder.type(MediaType.APPLICATION_JSON);
builder.header(HttpHeaders.AUTHORIZATION, "Negotiate " + token);

return builder.get(String.class);

*/
