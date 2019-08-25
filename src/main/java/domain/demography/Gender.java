package domain.demography;

public class Gender {

    private String genderId;
    private String desc;

    private Gender(){

    }

    public Gender(Builder builder){

        this.genderId = builder.genderId;
        this.desc = builder.desc;

    }


    public String getGenderId(){
        return genderId;
    }

    public String getDesc(){
        return desc;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }


    public static class Builder {

        private String genderId;
        private String desc;

        public Builder id(String id){

            this.genderId = id;
            return this;

        }

        public Builder desc(String desc){

            this.desc = desc;
            return this;

        }

        public Gender build(){

            return new Gender(this);

        }


    }


}
