package net.technearts.javapom;

/**
 * A java pom generator
 * 
 */
@GAV("net.technearts:javapom:0.0.1-SNAPSHOT")
@Name("javapom")
@Url("http://javapom.com")
@Packaging(PackageType.JAR)
@Inception(2017)
@Organization(value="Technearts", url=@Url("http://www.technearts.net"))
@CiManagement(value="Travis", url=@Url("http://www.travis.org"))
@IssueManagement(value="github", url=@Url("http://github.com"))
@Scm(url=@Url("http://github"),connection=@Url("http://github"),developerConnection=@Url("http://github"))
@Properties({"project.build.sourceEncoding->UTF-8", "maven.compiler.source->1.8", "maven.compiler.target->1.8"})
public class App extends AbstractPom{
    
    @Name("Contributor")
    @Email("contributor@technearts.net")
    @Organization(value="Technearts", url=@Url("http://www.technearts.net"))
    @Url("http://localhost")
    @Roles("None")
    @Timezone("GMT")
    @Properties("twitter -> @contributor")
    Contributor contributor;
    
    @Name("Paulo")
    @Email("paulo.suderio@technearts.net")
    @Organization(value="Technearts", url=@Url("http://www.technearts.net"))
    @Url("http://localhost")
    @Roles("All")
    @Timezone("GMT-3")
    @Properties("twitter -> @paulo.suderio")
    Developer paulo;
    
    @GAV("junit:junit:3.8.1")
    @Packaging(PackageType.JAR)
    @Scope(ScopeType.test)
    ManagedDependency junitManaged;
    
    /**
     * No comments
     */
    @Name("Mit")
    @Url("http://mit.org")
    @LicenseDistribution(DistributionType.Repo)
    License mit;
    
    @Name("list")
    @Url("http://maillistarchive.com")
    @Email("post@technearts.net")
    @Mailing(subscribe=@Email("subscribe@technearts.net"), unsubscribe=@Email("unsubscribe@technearts.net"), otherArchives=@Url("http://othermaillistarchive.com"))
    MailingList list;
    
    @GAV("junit:junit")
    @Scope(ScopeType.test)
    Dependency junit;
    
    public static void main(String[] args) {
        App app = new App();
        app.main();
    }
}
