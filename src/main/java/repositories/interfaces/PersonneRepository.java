package repositories.interfaces;

import models.Personne;

public interface PersonneRepository {
     void addPersonne(Personne p);
    Personne findPersonne(int id);
    void deletePersonne(int id);
    void updatePersonne(int id);

}
