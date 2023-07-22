SECRET_PLAINTEXT='You have a deep, dark fear of spiders, circa 1990'

#or alternatively ;p
#SECRET_PLAINTEXT='You have a deep, dark fear of clowns, circa 1990'

SECRET_256_HEX=$(echo -n $SECRET_PLAINTEXT| sha256sum | cut -d\  -f1)

SECRET_256_BIN=$(bc <<< "ibase=16; obase=2; ${SECRET_256_HEX^^}" | perl -pe 's/(\\)?\n//g')

echo -n $SECRET_256_BIN | wc -c
