package isil.pe.springdatajpa.auth;

import isil.pe.springdatajpa.visittas.VisittasDto;

public interface UserSecurityService {

  UserSecurity findUserSecurity(String email, String password);


  UserSecurity findUserByEmail(String email);
  VisittasDto addUserSecurity(UserSecurity user);

  UserSecurity findById(Long id);
  UserSecurity changePassword(UserSecurity user, String newPassword);

}
