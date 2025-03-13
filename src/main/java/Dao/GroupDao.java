package Dao;

import entity.Group;

public interface GroupDao  {
    public void createGroup(Group group);
    public void deleteGroup(int id);
    public void updateGroup(Group group);
    public void getGroupByİd(int id);
    public void getAllGroup();
}
