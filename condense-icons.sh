cd game-icons.net.png/icons
pwd

#find . -mindepth 6 -name *.png  -type f | while read file; do
	#echo $file
    #mv "$file" "$(dirname "$file")/../../.."
	#echo "deleting $(dirname "$file")/../../png"
	#rm -rf "$(dirname "$file")"/../../png
#done

find . -name png -exec rm -rf '{}' \;