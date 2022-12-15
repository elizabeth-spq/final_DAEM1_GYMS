package isil.pe.springdatajpa.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import isil.pe.springdatajpa.visittas.VisittasDto;

import java.util.Optional;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {
  @Autowired
  private UserSecurityRepository userSecurityRepository;

  @Override
  public UserSecurity findUserSecurity(String email, String password) {
    Optional<UserSecurity> userToFind = userSecurityRepository.findUserSecurityByEmailAndPassword(email, password);
    if (userToFind.isPresent()) {
      return userToFind.get();
    } return null;
  }

  @Override
  public UserSecurity findUserByEmail(String email) {
    Optional<UserSecurity> userToFind = userSecurityRepository.findUserByEmail(email);
    if (userToFind.isPresent()) {
      return userToFind.get();
    }
    return null;
  }


  @Override
  public VisittasDto addUserSecurity(UserSecurity user) {

    Optional<UserSecurity> userToAdd = userSecurityRepository.findUserByEmail(user.getEmail());
    if (userToAdd.isPresent()) {
      return VisittasDto.whenUserDniAlreadyExists();
    }
    userSecurityRepository.save(user);
    return VisittasDto.whenRegistrationSucced();


  }



  public UserSecurity changePassword(UserSecurity user, String newPassword) {
    Optional<UserSecurity> userToUpdate = userSecurityRepository.findById(user.getId());
    if (userToUpdate.isPresent()) {
      UserSecurity userSecurity = userToUpdate.get();
      userSecurity.setName(userSecurity.getName());
      userSecurity.setId(userSecurity.getId());
      userSecurity.setEmail(userSecurity.getEmail());
      userSecurity.setPassword(newPassword);
      userSecurityRepository.save(userSecurity);
      return userSecurity;
    } else {
      return null;
    }
  }

  public UserSecurity findById(Long id) {
    Optional<UserSecurity> userToFind = userSecurityRepository.findById(id);
    if (userToFind.isPresent()) {
      return userToFind.get();
    } else {
      return null;
    }
  }
}
