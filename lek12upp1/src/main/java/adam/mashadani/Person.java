package adam.mashadani;

public class Person {
    public String namn;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((namn == null) ? 0 : namn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (namn == null) {
            if (other.namn != null)
                return false;
        } else if (!namn.equals(other.namn))
            return false;
        return true;
    }

    
}
