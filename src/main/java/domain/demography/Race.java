package domain.demography;

public class Race {

    private String raceId;
    private String desc;

    private Race(){

    }

    public Race(Builder builder){

        this.raceId = builder.raceId;
        this.desc = builder.desc;

    }

    public String getRaceId(){

        return raceId;

    }

    public void setRaceId(String raceId){

        this.raceId = raceId;

    }

    public String getDesc(){

        return desc;

    }

    public void setDesc(String desc){

        this.desc = desc;

    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String raceId;
        private String desc;

        public Builder raceID(String raceID){

            this.raceId = raceID;
            return this;

        }

        public Builder desc(String desc){

            this.desc = desc;
            return this;


        }

        public Race build(){

            return new Race(this);

        }

    }




}
