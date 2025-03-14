package Dao;

import entity.Group;
import exception.DatabaseException;
import exception.EntityNotFoundException;

import java.util.List;

public interface GroupDao  {
    public void createGroup(Group group)throws DatabaseException;
    public void deleteGroup(int id)throws EntityNotFoundException;
    public void updateGroup(Group group);
    Group getGroupByİd(int id);
    List<Group> getAllGroups();
}
