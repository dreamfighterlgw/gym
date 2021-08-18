# 访问数据库
## 分为四步
###1、在库中建表，注意:
实体类为CompanyName，则表为company_name
实体类中属性名为：domainName，则表中字段名为：domain_name
即大写字母 VS _+小写字母

###2、建立实体类
@Entity
public class CompanyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    }
###3、建立存储接口
public interface CompanyNameRepository extends JpaRepository<CompanyName,Integer> {
    //@Query("select u from companyname u where u.domainName = ?1")
    List<CompanyName> findByDomainName(String domainName);
}

###4、建立访部控制器类
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;
    
      @GetMapping(value="/companyName")
        public List<CompanyName> getCompanyName(@RequestParam(value = "domainName" ,required = true) String domainName ){
            return  companyNameRepository.findByDomainName(domainName);
        }


}