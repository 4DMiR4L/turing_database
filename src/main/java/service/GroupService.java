package service;


    import Dao.GroupDao;
    import entity.Group;
    import exception.DatabaseException;

    import java.util.List;

    public class GroupService {
        private GroupDao groupDao;

        public GroupService(GroupDao groupDao) {
            this.groupDao = groupDao;
        }

        public void addGroup(Group group) {
            try {
                groupDao.createGroup(group);
                System.out.println("Group added successfully.");
            } catch (DatabaseException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public void listGroups() {
            List<Group> groups = groupDao.getAllGroups();
            for (Group g : groups) {
                System.out.println(g.getId() + " - " + g.getName() + ": " + g.getDescription());
            }
        }
    }

