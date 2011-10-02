java -Xmx1536M -XX:MaxPermSize=256m -Xss2M -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launcher.jar "$@"
