package DAO;

import Entity.Worker;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class DAOWorkerManager extends aDAOManager implements DAOManager<Worker>
{
  EntityManager em = aDAOManager.getEm();
  @Override
  public void insert(Worker worker)
  {
    EntityTransaction tm = em.getTransaction();
    tm.begin();
    em.persist(worker);
    tm.commit();
  }

  @Override
  public List<Worker> get()
  {
    TypedQuery<Worker> query = em.createQuery("SELECT new Entity.Worker(c.name, c.secName, c.numOfBrigade, c.personnelNum) from Worker c", Worker.class);
    List<Worker> listOfWorkers = query.getResultList();
    return listOfWorkers;
  }

  @Override
  public void remove(Worker worker)
  {
    String name = worker.getName();
    String secName = worker.getSecName();
    int numOfBrigade = worker.getNumOfBrigade();
    String personnelNum = worker.getPersonnelNum();
    em.getTransaction().begin();
    Query query = em.createQuery("delete from Worker c where c.name=:name and c.secName =:secName"
        + " and c.numOfBrigade=:numOfBrigade and c.personnelNum=:personnelNum");
    query.setParameter("name", name);
    query.setParameter("secName", secName);
    query.setParameter("numOfBrigade", numOfBrigade);
    query.setParameter("personnelNum", personnelNum);
    query.executeUpdate();
    em.getTransaction().commit();
  }

  @Override
  public void update(Worker worker)
  {

  }
}
