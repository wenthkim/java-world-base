#### Linux常用命令分类

> 文件基本属性
```
ls -l  #查看详细信息
dr-xr-xr-x   2 root root 4096 Dec 14  2012 bin
ls -a  #查看所有，包括隐藏文件
```  
在Linux中第一个字符代表这个文件是目录、文件或链接文件等等。  
当为[ d ]则是目录  
当为[ - ]则是文件；  
若是[ l ]则表示为链接文档(link file)；  
若是[ b ]则表示为装置文件里面的可供储存的接口设备(可随机存取装置)；  
若是[ c ]则表示为装置文件里面的串行端口设备，例如键盘、鼠标(一次性读取装置)  

|文件所有者|所有者同组用户|其它用户|代表意思|  
|---|:---:|---:|:---:|
|rwx|r--|r-x|r-4-读 w-2-写 x-1-执行|

> 目录跳转


|命令|说明|
|---|:---:|
|cd ~|进入当前用户家目录|
|cd  |进入当前用户家目录|
|cd -|进入上次目录|
|cd ..|进入上一级目录|
|cd .|进入当前目录|

> 文件目录

|命令|说明|
|---|:---:|
|pwd|查看当前所在路径|
|mkdir /test|创建目录|
|mkdir -p /test/t1/|创建多级目录|
|cp -r source target|复制目录及目录下的所有文件和文件夹|
|cp -f source target|强行复制，如果存在就覆盖|
|cp -i source target|覆盖已有文件前询问|
|mv source target|移动或改名|
|rm -rf target|删除文件或目录 -r 删除目录  -f 强制执行|
|tree /|树形显示根目录|
|touch file|创建空文件|
|vi file|编辑文件|
|cat file|查看文件|
|less file|查看文件|
|more file|查看文件|
|tail -f file|从尾部查看文件|
|tac file|从最后一行开始看|
|head -2 file|查看文件头两行|

> 文件搜索

|命令|说明|
|---|:---:|
|find / -name file1|跟据名字从 '/' 开始进入根文件系统搜索文件和目录|
|find / -user user1|跟据用户搜索属于用户 'user1' 的文件和目录|


> 文本处理

cat file1 file2 ... | command <> file1_in.txt_or_file1_out.txt general syntax for text manipulation using PIPE, STDIN and STDOUT   
cat file1 | command( sed, grep, awk, grep, etc...) > result.txt 合并一个文件的详细说明文本，并将简介写入一个新文件中   
cat file1 | command( sed, grep, awk, grep, etc...) >> result.txt 合并一个文件的详细说明文本，并将简介写入一个已有的文件中   
grep Aug /var/log/messages 在文件 '/var/log/messages'中查找关键词"Aug"   
grep ^Aug /var/log/messages 在文件 '/var/log/messages'中查找以"Aug"开始的词汇   
grep [0-9] /var/log/messages 选择 '/var/log/messages' 文件中所有包含数字的行   
grep Aug -R /var/log/* 在目录 '/var/log' 及随后的目录中搜索字符串"Aug"   
sed 's/stringa1/stringa2/g' example.txt 将example.txt文件中的 "string1" 替换成 "string2"   
sed '/^$/d' example.txt 从example.txt文件中删除所有空白行   
sed '/ *#/d; /^$/d' example.txt 从example.txt文件中删除所有注释和空白行   
echo 'esempio' | tr '[:lower:]' '[:upper:]' 合并上下单元格内容   
sed -e '1d' result.txt 从文件example.txt 中排除第一行   
sed -n '/stringa1/p' 查看只包含词汇 "string1"的行   
sed -e 's/ *$//' example.txt 删除每一行最后的空白字符   
sed -e 's/stringa1//g' example.txt 从文档中只删除词汇 "string1" 并保留剩余全部   
sed -n '1,5p;5q' example.txt 查看从第一行到第5行内容   
sed -n '5p;5q' example.txt 查看第5行   
sed -e 's/00*/0/g' example.txt 用单个零替换多个零   
cat -n file1 标示文件的行数   
cat example.txt | awk 'NR%2==1' 删除example.txt文件中的所有偶数行   
echo a b c | awk '{print $1}' 查看一行第一栏   
echo a b c | awk '{print $1,$3}' 查看一行的第一和第三栏   
paste file1 file2 合并两个文件或两栏的内容   
paste -d '+' file1 file2 合并两个文件或两栏的内容，中间用"+"区分   
sort file1 file2 排序两个文件的内容   
sort file1 file2 | uniq 取出两个文件的并集(重复的行只保留一份)   
sort file1 file2 | uniq -u 删除交集，留下其他的行   
sort file1 file2 | uniq -d 取出两个文件的交集(只留下同时存在于两个文件中的文件)   
comm -1 file1 file2 比较两个文件的内容只删除 'file1' 所包含的内容   
comm -2 file1 file2 比较两个文件的内容只删除 'file2' 所包含的内容   
comm -3 file1 file2 比较两个文件的内容只删除两个文件共有的部分     

> 挂载

mount /dev/hda2 /mnt/hda2 挂载一个叫做hda2的盘 - 确定目录 '/ mnt/hda2' 已经存在   
umount /dev/hda2 卸载一个叫做hda2的盘 - 先从挂载点 '/ mnt/hda2' 退出   
fuser -km /mnt/hda2 当设备繁忙时强制卸载   
umount -n /mnt/hda2 运行卸载操作而不写入 /etc/mtab 文件- 当文件为只读或当磁盘写满时非常有用   
mount /dev/fd0 /mnt/floppy 挂载一个软盘   
mount /dev/cdrom /mnt/cdrom 挂载一个cdrom或dvdrom   
mount /dev/hdc /mnt/cdrecorder 挂载一个cdrw或dvdrom   
mount /dev/hdb /mnt/cdrecorder 挂载一个cdrw或dvdrom   
mount -o loop file.iso /mnt/cdrom 挂载一个文件或ISO镜像文件   
mount -t vfat /dev/hda5 /mnt/hda5 挂载一个Windows FAT32文件系统   
mount /dev/sda1 /mnt/usbdisk 挂载一个usb 捷盘或闪存设备   
mount -t smbfs -o username=user,password=pass //WinClient/share /mnt/share 挂载一个windows网络共享  

> 用户和群组

groupadd group_name 创建一个新用户组   
groupdel group_name 删除一个用户组   
groupmod -n new_group_name old_group_name 重命名一个用户组   
useradd -c "Name Surname " -g admin -d /home/user1 -s /bin/bash user1  创建一个属于 "admin" 用户组的用户   
useradd user1 创建一个新用户   
userdel -r user1 删除一个用户 ( '-r' 排除主目录)   
usermod -c "User FTP" -g system -d /ftp/user1 -s /bin/nologin user1 修改用户属性   
passwd 修改口令   
passwd user1 修改一个用户的口令 (只允许root执行)   
chage -E 2005-12-31 user1 设置用户口令的失效期限   
pwck 检查 '/etc/passwd' 的文件格式和语法修正以及存在的用户   
grpck 检查 '/etc/passwd' 的文件格式和语法修正以及存在的群组   
newgrp group_name 登陆进一个新的群组以改变新创建文件的预设群组   

> 文件的权限 - 使用 "+" 设置权限，使用 "-" 用于取消 

ls -lh 显示权限   
ls /tmp | pr -T5 -W$COLUMNS 将终端划分成5栏显示   
chmod ugo+rwx directory1 设置目录的所有人(u)、群组(g)以及其他人(o)以读（r ）、写(w)和执行(x)的权限   
chmod go-rwx directory1 删除群组(g)与其他人(o)对目录的读写执行权限   
chown user1 file1 改变一个文件的所有人属性   
chown -R user1 directory1 改变一个目录的所有人属性并同时改变改目录下所有文件的属性   
chgrp group1 file1 改变文件的群组   
chown user1:group1 file1 改变一个文件的所有人和群组属性   
find / -perm -u+s 罗列一个系统中所有使用了SUID控制的文件   
chmod u+s /bin/file1 设置一个二进制文件的 SUID 位 - 运行该文件的用户也被赋予和所有者同样的权限   
chmod u-s /bin/file1 禁用一个二进制文件的 SUID位   
chmod g+s /home/public 设置一个目录的SGID 位 - 类似SUID ，不过这是针对目录的   
chmod g-s /home/public 禁用一个目录的 SGID 位   
chmod o+t /home/public 设置一个文件的 STIKY 位 - 只允许合法所有人删除文件   
chmod o-t /home/public 禁用一个目录的 STIKY 位     

> 打包和压缩文件

bunzip2 file1.bz2 解压一个叫做 'file1.bz2'的文件   
bzip2 file1 压缩一个叫做 'file1' 的文件   
gunzip file1.gz 解压一个叫做 'file1.gz'的文件   
gzip file1 压缩一个叫做 'file1'的文件   
gzip -9 file1 最大程度压缩   
rar a file1.rar test_file 创建一个叫做 'file1.rar' 的包   
rar a file1.rar file1 file2 dir1 同时压缩 'file1', 'file2' 以及目录 'dir1'   
rar x file1.rar 解压rar包   
unrar x file1.rar 解压rar包   
tar -cvf archive.tar file1 创建一个非压缩的 tarball   
tar -cvf archive.tar file1 file2 dir1 创建一个包含了 'file1', 'file2' 以及 'dir1'的档案文件   
tar -tf archive.tar 显示一个包中的内容   
tar -xvf archive.tar 释放一个包   
tar -xvf archive.tar -C /tmp 将压缩包释放到 /tmp目录下   
tar -cvfj archive.tar.bz2 dir1 创建一个bzip2格式的压缩包   
tar -xvfj archive.tar.bz2 解压一个bzip2格式的压缩包   
tar -cvfz archive.tar.gz dir1 创建一个gzip格式的压缩包   
tar -xvfz archive.tar.gz 解压一个gzip格式的压缩包   
zip file1.zip file1 创建一个zip格式的压缩包   
zip -r file1.zip file1 file2 dir1 将几个文件和目录同时压缩成一个zip格式的压缩包   
unzip file1.zip 解压一个zip格式压缩包   